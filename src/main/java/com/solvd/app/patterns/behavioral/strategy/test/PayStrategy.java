package com.solvd.app.patterns.behavioral.strategy.test;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
