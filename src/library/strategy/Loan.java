package library.strategy;

/**
 * Clase que gestiona el préstamo de un material. Utiliza una instancia de PenaltyStrategy para calcular la multa final, 
 * sin necesidad de conocer los detalles internos de cómo se calcula dicha penalización.
 */

public class Loan {
    private PenaltyStrategy strategy;

    public void setStrategy(PenaltyStrategy strategy) {
        this.strategy = strategy;
    }

    public double finalizeReturn(int daysLate) {
        if (strategy == null) return 0;
        return strategy.calculatePenalty(daysLate);
    }
}