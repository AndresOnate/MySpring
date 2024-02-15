package org.example;

@Component
public class HelloController {

    @GetMapping("/hello")
    public static String index(String a) {
        return "Greetings from Spring Boot!   " + a;
    }

}