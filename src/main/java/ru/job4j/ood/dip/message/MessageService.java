package ru.job4j.ood.dip.message;

public class MessageService {
    EmailMessage emailMessage = new EmailMessage();

    public void toMessage(String message) {
        emailMessage.message(message);
    }
}
