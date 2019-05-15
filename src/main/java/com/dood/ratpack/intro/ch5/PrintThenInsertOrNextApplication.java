package com.dood.ratpack.intro.ch5;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Shows how handlers can add child handlers as part of an insert
 */
public class PrintThenInsertOrNextApplication implements Handler {
    public void handle(Context context) {
        context.insert(
                new PrintThenInsertOrNextHandler("a",
                        new PrintThenInsertOrNextHandler("a.1"),
                        new PrintThenInsertOrNextHandler("a.2")
                ),
                new PrintThenInsertOrNextHandler("b",
                        new PrintThenInsertOrNextHandler("b.1",
                                new PrintThenInsertOrNextHandler("b.1.1"))
                ),
                new PrintThenInsertOrNextHandler("c")
        );
    }
}

