package com.dood.ratpack.intro.ch4;

import ratpack.server.ServerConfig;
import ratpack.test.embed.EphemeralBaseDir;
import ratpack.test.embed.EmbeddedApp;

import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;


public class ConfigExample {
    public static void main(String... args) throws Exception {
        EphemeralBaseDir.tmpDir().use(baseDir -> {
            baseDir.write("mydir/.ratpack", ""); //the basedir is in systemTmp
            baseDir.write("mydir/assets/message.txt", "Hello Ratpack!"); //create the message.txt file with content
            Path mydir = baseDir.getRoot().resolve("mydir");

            ClassLoader classLoader = new URLClassLoader(new URL[]{mydir.toUri().toURL()});
            Thread.currentThread().setContextClassLoader(classLoader);

            EmbeddedApp.of(serverSpec -> serverSpec
                    .serverConfig(c -> c.baseDir(mydir))
                    .handlers(chain ->
                            chain.files(f -> f.dir("assets"))
                    )
            ).test(httpClient -> {
                String message = httpClient.getText("message.txt");
                assertEquals("Hello Ratpack!", message);
            });
        });
    }
}
