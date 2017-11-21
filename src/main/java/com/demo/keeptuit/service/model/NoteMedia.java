package com.demo.keeptuit.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Media type for note
 */
@ApiModel(value = "Note", description = "A note")
public class NoteMedia extends AbstractMediaType {
    public static final String MEDIA_TYPE = MEDIA_TYPE_NAME_BASE + "note" + SERIALIZATION_FORMAT_JSON;

    private Long id;
    private String title;
    private String content;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ApiModelProperty(example = "\"note-title\"", value = "The note title", required = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ApiModelProperty(example = "\"note-content\"", value = "The note details", required = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public NoteMedia withId(Long id) {
        this.id = id;
        return this;
    }
    public NoteMedia withContents(String contents) {
        this.content = contents;
        return this;
    }

    public NoteMedia withUserName(String userName) {
        this.userName = userName;
        return this;
    }
}

