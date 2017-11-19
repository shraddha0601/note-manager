package com.demo.keeptuit.model;

/**
 * Media type for note
 */
public class NoteMedia extends AbstractMediaType {
    public static final String MEDIA_TYPE = MEDIA_TYPE_NAME_BASE + "note" + SERIALIZATION_FORMAT_JSON;

    private String id;
    private String title;
    private String contents;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public NoteMedia withTitle(String title) {
        this.title = title;
        return this;
    }

    public NoteMedia withContents(String contents) {
        this.contents = contents;
        return this;
    }
    public NoteMedia withId(String id) {
        this.id = id;
        return this;
    }

    public NoteMedia withUserName(String userName) {
        this.userName = userName;
        return this;
    }
}

