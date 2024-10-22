package ru.job4j.ood.ocp;

public class MessageManager {
    public void message(String messageType) {
        if (messageType.equals("telegram")) {
            System.out.println("Логика отправлки сообщеняи в телеграмм");
        } else if (messageType.equals("email")) {
            System.out.println("Логика отправлки сообщеняи в email");
        } else if (messageType.equals("mobile")) {
            System.out.println("Логика отправлки сообщеняи в mobile");
        } else {
            throw new IllegalArgumentException("Unknown message type: " + messageType);
        }
    }
}
