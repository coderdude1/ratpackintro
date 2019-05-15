package com.dood.ratpack.intro.ch5;

import ratpack.server.RatpackServer;

/**
 * Console output is as follows.  the browser gets the pretty 404 dev error page
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenInsertOrNextHandler - a
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenInsertOrNextHandler - a.1
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenInsertOrNextHandler - a.2
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenInsertOrNextHandler - b
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenInsertOrNextHandler - b.1
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenInsertOrNextHandler - b.1.1
 * [ratpack-compute-1-2] INFO com.dood.ratpack.intro.ch5.PrintThenInsertOrNextHandler - c
 * [ratpack-compute-1-2] ERROR ratpack.error.internal.DefaultDevelopmentErrorHandler - 404 client error for request to /
 */
public class RunPrintThenInsertOrNextApplication {
    public static void main(String[] args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain.all(new PrintThenInsertOrNextApplication()) )
        );
    }
}
