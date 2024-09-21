package com.example.demo.voucher;

import com.example.demo.voucher.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    Voucher findByTransactionId(String transactionId);

}
