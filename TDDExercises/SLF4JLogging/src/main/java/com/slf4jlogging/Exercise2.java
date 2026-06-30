package com.slf4jlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise2 {

    private static final Logger logger = LoggerFactory.getLogger(Exercise2.class);

    public static void main(String[] args) {
        String username = "Abhi";
        int age = 25;

        logger.info("User {} has logged in", username);
        logger.debug("User age is {}", age);
        logger.warn("User {} has {} failed login attempts", username, 3);
        logger.error("User {} account is locked after {} attempts", username, 5);
    }
}
