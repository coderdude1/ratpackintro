package com.dood.ratpack.intro.ch5;

import ratpack.server.RatpackServer;

public class RunRouterChain {
    public static void main(String[] args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(new RouterChain())
        );
    }
}
