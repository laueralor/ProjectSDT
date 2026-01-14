package library;

public class ProfessorPenalty implements PenaltyStrategy {
    @Override
    public double calculatePenalty(int daysLate) {
        return daysLate * 0.5;
    }
}