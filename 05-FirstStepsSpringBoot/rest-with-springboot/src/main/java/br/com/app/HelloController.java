package br.com.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController // Junção @Controller + @ResponseBody
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); //AtomicLong mocka um Id

    @RequestMapping("/hello")
    public Hello hello(
            @RequestParam(value = "name", defaultValue = "World")
            String name){
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }

}
