package com.demo.keeptuit.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @Size(max = TITLE_MAX_LENGTH, message = TITLE_INVALID_NAME)
    @NotBlank(message = MSG_REQUIRED_TITLE)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Size(max = CONTNENT_MAX_LENGTH, message = CONTENT_INVALID_NAME)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = UserDb.class, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    public UserDb getUser() {
        return user;
    }

    public void setUser(UserDb user) {
        this.user = user;
    }

    public NoteDb withTitle(String name) {
        this.title = name;
        return this;
    }

    public NoteDb withContent(String content) {
        this.content = content;
        return this;
    }
}
