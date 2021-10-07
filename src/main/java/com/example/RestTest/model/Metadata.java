package com.example.RestTest.model;

/**
 * Represents Programme Metadata
 * @author David McInnes
 * @since 1.0
 */
public class Metadata {
    
    public long id;
    public String description;

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
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }
}
