package com.kaio.jsonconsumer.listener;

import com.kaio.jsonconsumer.model.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@Log4j2
public class jsonListener {

    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) throws InterruptedException {
        log.info("Recebi o pagamento {}", payment.toString());
        sleep(1000);
        log.info("Validando fraude...");
        sleep(2000);

        log.info("Compra aprovada...");
        sleep(2000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) throws InterruptedException {
        sleep(3000);
        log.info("Gerando PDF do produto id {}...", payment.getIdProduct());
        sleep(2000);
    }

    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment) throws InterruptedException {
        sleep(3000);
        log.info("Enviando email de confirmação do usuario de id {}...", payment.getIdUser());
    }

}
