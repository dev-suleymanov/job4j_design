package ru.job4j.ood.isp.payment;

public interface Payment {
    void payByCard(String cardDetails);
    void payByCash();
}