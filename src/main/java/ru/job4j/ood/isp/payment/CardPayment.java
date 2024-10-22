package ru.job4j.ood.isp.payment;

public class CardPayment implements Payment {
    @Override
    public void payByCard(String cardDetails) {
        System.out.println("payByCard");
    }

    @Override
    public void payByCash() {

    }
}
