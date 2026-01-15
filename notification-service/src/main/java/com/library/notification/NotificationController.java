package com.library.notification;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationRequest request) {
        // Aquí simulamos el patrón Observer: el "Subject" avisa a este servicio
        return "Notificación sended to " + request.recipient + ": " + request.message;
    }
}

class NotificationRequest {
    public String recipient;
    public String message;
}