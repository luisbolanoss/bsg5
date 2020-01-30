package com.bsg5.chapter2;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class SpringGreeterTest {

    @Test
    public void testHelloWorld() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Greeter greeter = context.getBean("helloGreeter", Greeter.class);
        ByteArrayOutputStream baos = context.getBean("baos", ByteArrayOutputStream.class);

        greeter.greet();
        String data = new String(baos.toByteArray(), StandardCharsets.UTF_8);

        assertEquals(data, "Hello, World!");
    }
}