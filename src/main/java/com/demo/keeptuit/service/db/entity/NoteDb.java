package com.demo.keeptuit.service.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity for Note table
 */
@Entity()
@Table(name = "Note",
        uniqueConstraints = @UniqueConstraint(columnNames = {"title", "user_id"}))
public class NoteDb extends Versioned {

    private static final int TITLE_MAX_LENGTH = 15;
    private static final String TITLE_INVALID_NAME = "Note title is invalid";
    private static final String MSG_REQUIRED_TITLE = "Note title cannot be left blank";
    private static final int CONTNENT_MAX_LENGTH = 256;
    private static final String CONTENT_INVALID_NAME = "Note contents are invalid";


    private Long id;
    private String title;
    private String content;
    private UserDb user;

    /**
     * Gets title.
     *
     * @return the title
     */
    @Size(max = TITLE_MAX_LENGTH, message = TITLE_INVALID_NAME)
    @NotBlank(message = MSG_REQUIRED_TITLE)
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
    @Size(max = CONTNENT_MAX_LENGTH, message = CONTENT_INVALID_NAME)
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
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
     * Gets user.
     *
     * @return the user
     */
    @ManyToOne(targetEntity = UserDb.class, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    public UserDb getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user
     *         the user
     */
    public void setUser(UserDb user) {
        this.user = user;
    }

    /**
     * With title note db.
     *
     * @param name
     *         the name
     *
     * @return the note db
     */
    public NoteDb withTitle(String name) {
        this.title = name;
        return this;
    }

    /**
     * With content note db.
     *
     * @param content
     *         the content
     *
     * @return the note db
     */
    public NoteDb withContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * With user note db.
     *
     * @param user
     *         the user
     *
     * @return the note db
     */
    public NoteDb withUser(UserDb user) {
        this.user = user;
        return this;
    }

    /**
     * With id note db.
     *
     * @param id
     *         the id
     *
     * @return the note db
     */
    public NoteDb withId(long id) {
        this.id = id;
        return this;
    }
}
