package com.example.RestTest.model;


/**
 * Represents a Greeting.
 * @author David McInnes
 * @since 1.0
 */
public class Greeting {
    
    private final long id;
    private final String content;

    /**
     * Creates a Greeting with the specified id and content.
     * @param id
     * @param content
     */
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * Gets the ID
     * @return A long representing the Greeting id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the Content
     * @return A String representing the Greeting content
     */
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
