package com.nelio.hrpayroll.services;

import com.nelio.hrpayroll.entities.Payment;
import com.nelio.hrpayroll.entities.Worker;
import com.nelio.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);
        return payment;
    }

}
