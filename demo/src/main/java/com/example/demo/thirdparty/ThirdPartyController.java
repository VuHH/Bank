package com.example.demo.thirdparty;

import com.example.demo.security.PhoneNumberEncryption;
import com.example.demo.sms.SMSService;
import com.example.demo.voucher.Voucher;
import com.example.demo.voucher.VoucherRepository;
import com.example.demo.voucher.VoucherRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyController {
    private final VoucherRepository voucherRepository;
    private final SMSService smsService;
    private final PhoneNumberEncryption phoneNumberEncryption;

    ThirdPartyController(VoucherRepository voucherRepository, SMSService smsService, PhoneNumberEncryption phoneNumberEncryption) {
        this.voucherRepository = voucherRepository;
        this.smsService = smsService;
        this.phoneNumberEncryption = phoneNumberEncryption;
    }

    @PostMapping("/sendBackVoucherCode")
    String sendBackVoucherCode(@RequestBody VoucherRequest voucherRequest) {
        try {
            Voucher voucher = voucherRepository.findByTransactionId(voucherRequest.getTransactionId());
            voucher.setVoucherCode(voucherRequest.getVoucherCode());
            voucher.setActive(true);
            voucherRepository.save(voucher);
            smsService.sendSMS(phoneNumberEncryption.decryptPhone(voucher.getPhoneNumber()), voucher.getVoucherCode());
            return "success";
        } catch (Exception ex) {
            return "error";
        }
    }
}
