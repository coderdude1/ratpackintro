package com.dood.ratpack.intro.ch5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PrintThenNextHandler implements Handler {
    private final String message;
    private final static Logger LOGGER = LoggerFactory.getLogger(PrintThenNextHandler.class);


    public PrintThenNextHandler(String message) {
        this.message = message;
    }

    @Override
    public void handle(Context context) {
        LOGGER.info(message);
        context.next();
    }
}