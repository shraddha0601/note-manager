package com.demo.keeptuit.db.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Note")
public class NoteDb extends Versioned {

    private Long id;
    private String title;
    private String content;
    private UserDb user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
