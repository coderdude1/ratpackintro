package com.dood.ratpack.intro.ch5;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class FooHandler implements Handler {
    public void handle(Context context) {
        context.getResponse().send("foo");
    }
}
