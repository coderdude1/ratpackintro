package com.dood.ratpack.intro.ch5;

import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Handler;

/**
 * This does the same thing as the Router class, just with less code.
 */
public class RouterChain implements Action<Chain> {
    private final Handler fooHandler = new FooHandler();
    private final Handler barHandler = new BarHandler();

    @Override
    public void execute(Chain chain) {
        chain.path("foo", fooHandler);
        chain.path("bar", barHandler);
    }
}