package com.example.demo.thirdparty;

import com.example.demo.voucher.VoucherRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Call3PService {
    private final RestTemplate restTemplate;

    @Value("${3P.voucher.url}")
    private String url;

    Call3PService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public VoucherRequest getVoucherFromThirdParty(String transactionId) {
        // Timeout : return null
        return restTemplate.postForObject(url, transactionId, VoucherRequest.class);
    }
}
