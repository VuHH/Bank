package com.example.demo.voucher;

import com.example.demo.security.PhoneNumberEncryption;
import com.example.demo.thirdparty.Call3PService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.DatatypeConverter;
import java.util.UUID;

@RestController
public class VoucherController {
    private final VoucherRepository voucherRepository;

    private final Call3PService call3PService;

    private final PhoneNumberEncryption phoneNumberEncryption;

    VoucherController(VoucherRepository voucherRepository, Call3PService call3PService, PhoneNumberEncryption phoneNumberEncryption) {
        this.voucherRepository = voucherRepository;
        this.call3PService = call3PService;
        this.phoneNumberEncryption = phoneNumberEncryption;
    }

    @GetMapping("/buyVoucher/{phoneNumberHash}")
    VoucherResponse buyVoucher(@PathVariable String phoneNumberHash) {
        try {
            String message = "";
            String transactionId = UUID.randomUUID().toString();
            Voucher voucher = new Voucher(transactionId, phoneNumberHash, null, false);
            voucherRepository.save(voucher);
            VoucherRequest voucherRequest = call3PService.getVoucherFromThirdParty(transactionId);
            if (voucherRequest.getVoucherCode() == null) {
                message = "The system is overloaded. The voucher will be sent to your SMS.";
            } else {
                voucher = voucherRepository.findByTransactionId(transactionId);
                voucher.setActive(true);
                voucher.setVoucherCode(voucherRequest.getVoucherCode());
                voucherRepository.save(voucher);
            }
            return new VoucherResponse(voucherRequest.getVoucherCode(), transactionId, message);
        } catch (Exception ex) {
            return null;
        }
    }

}
