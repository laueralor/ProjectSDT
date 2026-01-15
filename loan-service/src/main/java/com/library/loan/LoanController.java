package com.library.loan;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private RabbitTemplate rabbitTemplate; // Inyectamos el enviador de mensajes

    @GetMapping("/calculate-penalty")
    public String calculate(@RequestParam String userType, @RequestParam int daysLate) {
        double penalty = (userType.equalsIgnoreCase("student")) ? daysLate * 0.5 : daysLate * 1.0;
        
        String result = "Penalty for " + userType + ": " + penalty + " EUR";

        // ENVIAR MENSAJE A LA COLA
        // Esto es comunicación asíncrona: el Loan Service no espera a nadie
        rabbitTemplate.convertAndSend("libraryQueue", "New penalty generated: " + result);

        return result;
    }
}