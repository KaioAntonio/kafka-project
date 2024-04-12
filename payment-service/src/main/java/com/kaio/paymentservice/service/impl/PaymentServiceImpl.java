package com.kaio.paymentservice.service.impl;

import com.kaio.paymentservice.model.Payment;
import com.kaio.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void sendPayment(Payment payment) {
       log.info("PAYMENT_SERVICE_IMPL ::: Recebi o Pagamento {}", payment);

    }
}
