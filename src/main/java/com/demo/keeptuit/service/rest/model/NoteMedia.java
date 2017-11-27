package com.demo.keeptuit.service.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Media type for note
 */
@ApiModel(value = "Note", description = "A note")
public class NoteMedia extends AbstractMediaType {
    /**
     * The constant MEDIA_TYPE.
     */
    public static final String MEDIA_TYPE = MEDIA_TYPE_NAME_BASE + "note" + SERIALIZATION_FORMAT_JSON;

    private Long id;
    private String title;
    private String content;
    private String userName;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id
     *         the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    @ApiModelProperty(example = "note-title", value = "The note title", required = true)
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title
     *         the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    @ApiModelProperty(example = "note-content", value = "The note details", required = false)
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content
     *         the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName
     *         the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * With title note media.
     *
     * @param title
     *         the title
     *
     * @return the note media
     */
    public NoteMedia withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * With id note media.
     *
     * @param id
     *         the id
     *
     * @return the note media
     */
    public NoteMedia withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * With contents note media.
     *
     * @param contents
     *         the contents
     *
     * @return the note media
     */
    public NoteMedia withContents(String contents) {
        this.content = contents;
        return this;
    }

    /**
     * With user name note media.
     *
     * @param userName
     *         the user name
     *
     * @return the note media
     */
    public NoteMedia withUserName(String userName) {
        this.userName = userName;
        return this;
    }
}

