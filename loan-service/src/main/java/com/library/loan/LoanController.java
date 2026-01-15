package com.library.loan;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/calculate-penalty")
    public PenaltyResponse calculate(@RequestParam String userType, @RequestParam int daysLate) {
        double amount = 0;
        
        // Aplicamos la lógica del patrón Strategy que tenías en el Milestone 2
        if ("student".equalsIgnoreCase(userType)) {
            amount = daysLate * 2.0; // 2€ por día para estudiantes
        } else if ("professor".equalsIgnoreCase(userType)) {
            amount = daysLate * 0.5; // 0.50€ por día para profesores
        }

        return new PenaltyResponse(userType, daysLate, amount);
    }
}