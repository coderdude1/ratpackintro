package com.dood.ratpack.intro.ch5;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class Router implements Handler {
    private final Handler fooHandler = new FooHandler();
    private final Handler barHandler = new BarHandler();

    @Override
    public void handle(Context context) {
        String path = context.getRequest().getPath();
        if (path.equals("foo")) {
            context.insert(fooHandler);
        } else if (path.equals("bar")) {
            context.insert(barHandler);
        } else {
            //find and delegate to the next handler in the chain.  ie we didn't match.  Since we didn't
            //define one that returns something useful, an internal default that generates a pretty 404
            context.next();
        }
    }
}
