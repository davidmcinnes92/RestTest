package com.example.RestTest.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

import com.example.RestTest.model.Metadata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class with Web API operations on Metadata.
 * @author David McInnes
 * @since 1.0
 */
@RestController
public class MetadataController {

    public List<Metadata> metadataList = new ArrayList<Metadata>();
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/metadata")
    public Metadata metadata() {
        return new Metadata(counter.incrementAndGet(), "This is a test description.");
    }

}
