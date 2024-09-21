package com.example.demo.voucher;

public class VoucherResponse {

    private String voucherCode;
    private String transactionId;
    private String message;

    public VoucherResponse(String voucherCode, String transactionId, String message) {
        this.voucherCode = voucherCode;
        this.transactionId = transactionId;
        this.message = message;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
