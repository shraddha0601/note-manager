package com.demo.keeptuit.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
public class UserDb extends Versioned {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private List<NoteDb> notes = new ArrayList<>();


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(targetEntity = NoteDb.class, mappedBy = "user", fetch = FetchType.LAZY)
    public List<NoteDb> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDb> notes) {
        this.notes = notes;
    }


    public UserDb withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserDb withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDb withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDb withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDb withNotes(List<NoteDb> notes) {
        this.notes = notes;
        return this;
    }
}
