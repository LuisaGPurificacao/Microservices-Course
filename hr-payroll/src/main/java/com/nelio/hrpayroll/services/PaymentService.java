package com.nelio.hrpayroll.services;

import com.nelio.hrpayroll.entities.Payment;
import com.nelio.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+workerId);
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}" , Worker.class, uriVariables);
        //assert worker != null;
        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);
        return payment;
    }

}
