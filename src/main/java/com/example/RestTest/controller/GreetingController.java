package com.example.RestTest.controller;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.example.RestTest.model.Greeting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class with Web API operations on Greetings.
 * @author David McInnes
 * @since 1.0
 */
@RestController
public class GreetingController {

    public Set<Greeting> greetingSet = new HashSet<Greeting>();
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings") 
    public Set<Greeting> greetings() {
        return greetingSet;
    }

    @GetMapping("greeting/{id}")
    public Greeting greeting(@PathVariable int id) {

        // Iterate through the set finding the ID
        for (Greeting g: greetingSet) {
            if (g.getId() == id) {
                return g;
            }
        }

        return null;
    }

    @GetMapping("greeting/{id}/encoded")
    public String encodedGreeting(@PathVariable int id) {

        // Iterate through the set finding the ID
        for (Greeting g: greetingSet) {
            if (g.getId() == id) {
                return encodeBase64(g.getContent());
            }
        }

        return null;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping( value = "/greeting", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Set<Greeting>> createGreeting(@RequestBody String message) {
        greetingSet.add(new Greeting(counter.incrementAndGet(), message));
        return new ResponseEntity<Set<Greeting>>(greetingSet, HttpStatus.CREATED);
    } 

    @DeleteMapping("greeting/{id}")
    public Greeting deleteGreeting(@PathVariable int id) {

        // Iterate through the set finding the ID
        for (Greeting g: greetingSet) {
            if (g.getId() == id) {
                greetingSet.remove(g);
                return g;
            }
        }

        return null;
    }

    public static String encodeBase64(String textToEncode) {
        byte[] encodedBytes = Base64.getEncoder().encode(textToEncode.getBytes());
        return new String(encodedBytes);
    }

    public static String decodeBase64(String base64ToDecode) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64ToDecode);
        return new String(decodedBytes);
    }
}
