package com.slf4jlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise3 {

    private static final Logger logger = LoggerFactory.getLogger(Exercise3.class);

    public static void main(String[] args) {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }
}
