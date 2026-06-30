package com.slf4jlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise1 {

    private static final Logger logger = LoggerFactory.getLogger(Exercise1.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
