package library.strategy;

/**
 * Estrategia específica para profesores. Implementa una lógica de penalización diferenciada, generalmente con tarifas 
 * o reglas más flexibles que las de los estudiantes.
 */

public class ProfessorPenalty implements PenaltyStrategy {
    @Override
    public double calculatePenalty(int daysLate) {
        return daysLate * 0.5;
    }
}