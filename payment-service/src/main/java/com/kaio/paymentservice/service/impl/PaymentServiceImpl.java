package com.kaio.paymentservice.service.impl;

import com.kaio.paymentservice.model.Payment;
import com.kaio.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    @SneakyThrows
    public void sendPayment(Payment payment) {
       log.info("Recebi o Pagamento {}", payment);
       Thread.sleep(2000);

       log.info("Enviando pagamento ...");
       kafkaTemplate.send("payment-topic", payment);
    }
}
