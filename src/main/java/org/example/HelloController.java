package org.example;

@Component
public class HelloController {

    @GetMapping("/hello")
    public static String index() {
        return "Greetings from Spring Boot!";
    }

}