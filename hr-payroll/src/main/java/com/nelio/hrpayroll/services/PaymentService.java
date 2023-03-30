package com.nelio.hrpayroll.services;

import com.nelio.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days) {
        Payment payment = new Payment("Bob", 200.0, days);
        return payment;
    }

}
