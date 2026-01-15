package library.strategy;

/**
 * Estrategia específica para estudiantes. Implementa una lógica de cálculo de multa con una tarifa estándar por cada día 
 * de retraso en la devolución.
 */

public class StudentPenalty implements PenaltyStrategy {
    @Override
    public double calculatePenalty(int daysLate) {
        return daysLate * 2.0;
    }
}