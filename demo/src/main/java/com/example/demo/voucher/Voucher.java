package com.example.demo.voucher;

import jakarta.persistence.*;

@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private int voucherId;

    private String transactionId;
    private String phoneNumber;
    private String voucherCode;
    private boolean isActive;

    public Voucher(String transactionId, String phoneNumber, String voucherCode, boolean isActive) {
        this.transactionId = transactionId;
        this.phoneNumber = phoneNumber;
        this.voucherCode = voucherCode;
        this.isActive = isActive;
    }

    public Voucher() {
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
