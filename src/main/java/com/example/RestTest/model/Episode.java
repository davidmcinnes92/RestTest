package com.example.RestTest.model;

import java.time.*;

/**
 * Represents Programme Metadata
 * @author David McInnes
 * @since 1.0
 */
public class Episode {
    
    public long episodeID;
    public long showID;
    public String description;
    public LocalDateTime dateAvailable;

    // Empty constructor
    public Episode() {

    }

    /**
     * Creates Metadata with the specified ID and Description
     * @param id
     * @param description
     */
    public Episode(long id, String description) {
        this.episodeID = id;
        this.showID = id;
        this.description = description;
        this.dateAvailable = java.time.LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return episodeID;
    }

    public LocalDateTime getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(LocalDateTime dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public long getEpisodeID() {
        return episodeID;
    }

    public void setEpisodeID(long episodeID) {
        this.episodeID = episodeID;
    }
}
