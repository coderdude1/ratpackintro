package com.dood.ratpack.intro.ch6;

import ratpack.registry.Registry;
import ratpack.test.embed.EmbeddedApp;

import static org.junit.Assert.assertEquals;


public class RunApplication {
    public static void main(String... args) throws Exception {
        EmbeddedApp
                .fromHandlers(chain -> chain
                        .prefix("person/:id", personChain -> personChain
                                .all(ctx -> { //all incoming requests get this first.
                                    //the next line is same as 'ctx.get(PathBinding.class).getPathTokens() '
                                    String id = ctx.getPathTokens().get("id"); // (1) get the id from the request as a local var
                                    Person person = new PersonImpl(id, "example-status", "example-age");
                                    ctx.next(Registry.single(Person.class, person)); // (2) stuff the person on the registry
                                })
                                .get("status", ctx -> { //stuff in the .all are visible
                                    Person person = ctx.get(Person.class); // (3) get the person from the all step
                                    ctx.render("person " + person.getId() + " status: " + person.getStatus());
                                })
                                .get("age", ctx -> {
                                    Person person = ctx.get(Person.class); // (4) get the person from the all step
                                    ctx.render("person " + person.getId() + " age: " + person.getAge());
                                }))
                )
                .test(httpClient -> {
                    assertEquals("person 10 status: example-status", httpClient.get("person/10/status").getBody().getText());
                    assertEquals("person 6 age: example-age", httpClient.get("person/6/age").getBody().getText());
                });
    }
}
