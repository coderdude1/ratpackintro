package com.dood.ratpack.intro.ch5;

import ratpack.server.RatpackServer;

public class RunRouter {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain.all(new Router())) //all means all requests coming in on this server get passed to this chain
        );
    }
}
