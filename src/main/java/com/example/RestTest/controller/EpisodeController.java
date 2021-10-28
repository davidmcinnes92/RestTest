package com.example.RestTest.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

import com.example.RestTest.model.Episode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class with Web API operations on Metadata.
 * @author David McInnes
 * @since 1.0
 */
@RestController
public class EpisodeController {

    public List<Episode> episodeList = new ArrayList<Episode>();
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/episode")
    public List<Episode> episode() {
        episodeList.add(new Episode(counter.incrementAndGet(), "This is a test description."));
        return episodeList;
    }

    @GetMapping("/episode/{id}")
    public Episode episode(@PathVariable int id) {
        
        // Get the episode with the given id
        for (Episode e: episodeList) {
            if (e.getEpisodeID() == id) {
                return e;
            }
        }

        return null;
    }

}
