package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Rustam";
        byte age = 28;
        char sex = 'M';
        double height = 176.0;
        float weight = 72.5f;
        boolean work = true;
        int number = 926715538;
        long card = 5536_9140_2700_1332L;
        short code = 479;
        System.out.println(card);
        LOG.debug("User name:{}, age:{}, sex:{}, height:{}, "
                        + "weight:{}, work:{}, number:{}, card:{}, code:{}",
                name, age, sex, height, weight, work, number, card, code);
    }
}