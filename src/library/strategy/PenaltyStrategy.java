package library.strategy;

/**
 * Interfaz que define la estructura para el cálculo de multas. Permite intercambiar diferentes algoritmos de penalización 
 * (para estudiantes o profesores) de forma dinámica gracias al patrón Strategy.
 */

public interface PenaltyStrategy {
    double calculatePenalty(int daysLate);
}