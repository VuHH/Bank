package com.example.demo.sms;

import org.springframework.stereotype.Service;

@Service
public class SMSService {
    public String sendSMS(String phoneNumber, String voucherCode)  {
        return "send to SMS success";
    }
}
