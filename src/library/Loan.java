package library;

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