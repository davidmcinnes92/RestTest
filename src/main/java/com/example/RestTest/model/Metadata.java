package com.example.RestTest.model;

import java.time.*;

/**
 * Represents Programme Metadata
 * @author David McInnes
 * @since 1.0
 */
public class Metadata {
    
    public long id;
    public String description;
    public LocalDateTime dateAvailable;

    // Empty constructor
    public Metadata() {

    }

    /**
     * Creates Metadata with the specified ID and Description
     * @param id
     * @param description
     */
    public Metadata(long id, String description) {
        this.id = id;
        this.description = description;
        this.dateAvailable = java.time.LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(LocalDateTime dateAvailable) {
        this.dateAvailable = dateAvailable;
    }
}
