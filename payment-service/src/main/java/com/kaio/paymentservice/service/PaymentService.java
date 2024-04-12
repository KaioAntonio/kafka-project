package com.kaio.paymentservice.service;

import com.kaio.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);

}
