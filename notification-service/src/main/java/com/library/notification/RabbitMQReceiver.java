package com.library.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {

    // Este método se activa solo cuando llega un mensaje a la cola "libraryQueue"
    @RabbitListener(queues = "libraryQueue")
    public void receiveMessage(String message) {
        System.out.println(" [x] NOTIFICACIÓN RECEIVED: " + message);
        // Aquí es donde el patrón Observer actúa de forma asíncrona
    }
}