package com.bsg5.chapter2;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.testng.annotations.Test;

public class GreeterTest {

    @Test
    public void testHelloWorld() {
        Greeter greeter = new HelloWorldGreeter();
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PrintStream ps = new PrintStream(baos, true, StandardCharsets.UTF_8);
        greeter.setPrintStream(ps);
        greeter.greet();

        String data = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(data, "Hello, World!");
    }
}
