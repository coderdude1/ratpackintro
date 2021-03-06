package com.dood.ratpack.intro.ch5;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class PrintThenNextApplication implements Handler {

    @Override
    public void handle(Context context) {
        context.insert(
                new PrintThenNextHandler("a"),
                new PrintThenNextHandler("b"),
                new PrintThenNextHandler("c")
        );
    }
}

/**
 * prints this out.  Note an error page as generated by the DefaultProductionHandler
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenNextHandler - a
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenNextHandler - b
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenNextHandler - c
 * [ratpack-compute-1-2] WARN ratpack.error.internal.DefaultProductionErrorHandler - Default production error handler used to render client error, please add a ratpack.error.ClientErrorHandler instance to your application (method: GET, uri: /blah)
 */