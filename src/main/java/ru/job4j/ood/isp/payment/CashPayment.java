package ru.job4j.ood.isp.payment;

public class CashPayment implements Payment {
    @Override
    public void payByCard(String cardDetails) {

    }

    @Override
    public void payByCash() {
        System.out.println("payByCash");
    }
}
