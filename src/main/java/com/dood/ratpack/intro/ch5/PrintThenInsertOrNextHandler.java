package com.dood.ratpack.intro.ch5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PrintThenInsertOrNextHandler implements Handler {
    private final String message;
    private final Handler[] handlers;
    private final static Logger LOGGER = LoggerFactory.getLogger(PrintThenInsertOrNextHandler.class);

    public PrintThenInsertOrNextHandler(String message, Handler... handlers) {
        this.message = message;
        this.handlers = handlers;
    }

    public void handle(Context context) {
        LOGGER.info(message);
        if (handlers.length == 0) {
            context.next();
        } else {
            context.insert(handlers);
        }
    }
}