package com.library.loan;

public class PenaltyResponse {
    public String userType;
    public int daysLate;
    public double penaltyAmount;
    public String currency = "EUR";

    public PenaltyResponse(String userType, int daysLate, double penaltyAmount) {
        this.userType = userType;
        this.daysLate = daysLate;
        this.penaltyAmount = penaltyAmount;
    }
}