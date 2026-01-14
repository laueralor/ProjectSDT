package library;

public class StudentPenalty implements PenaltyStrategy {
    @Override
    public double calculatePenalty(int daysLate) {
        return daysLate * 2.0;
    }
}