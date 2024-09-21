package com.example.demo.voucher;

public class VoucherRequest {
    private String transactionId;
    private String voucherCode;


    public VoucherRequest(String transactionId, String voucherCode) {
        this.transactionId = transactionId;
        this.voucherCode = voucherCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }
}
