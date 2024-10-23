package ru.job4j.ood.dip.message;

public class MessageService {
    EmailMessage emailMessage;

    public MessageService(EmailMessage emailMessage) {
        this.emailMessage = emailMessage;
    }

    public void toMessage(String message) {
        emailMessage.message(message);
    }
}
