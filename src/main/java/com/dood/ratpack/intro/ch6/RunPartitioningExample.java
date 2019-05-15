package com.dood.ratpack.intro.ch6;

import ratpack.error.ServerErrorHandler;
import ratpack.test.embed.EmbeddedApp;

import static org.junit.Assert.assertEquals;

public class RunPartitioningExample {
    public static void main(String... args) throws Exception {
        EmbeddedApp.fromHandlers(chain -> chain
                .prefix("api", api -> api //scope of the registry is bound in this block
                        .register(r -> r.add(ServerErrorHandler.class, (context, throwable) ->
                                        context.render("api error: " + throwable.getMessage())
                                )
                        )
                        .all(ctx -> {
                            throw new Exception("in api - " + ctx.getRequest().getPath()); //in scope of the 'api error'
                        })
                )
                .register(r -> r.add(ServerErrorHandler.class, (ctx, throwable) ->
                                ctx.render("app error: " + throwable.getMessage()) //not in previous api scope
                        )
                )
                .all(ctx -> {
                    throw new Exception("in app - " + ctx.getRequest().getPath());
                })
        ).test(httpClient -> {
            assertEquals("api error: in api - api/foo", httpClient.get("api/foo").getBody().getText());
            assertEquals("app error: in app - bar", httpClient.get("bar").getBody().getText());
        });
    }
}
