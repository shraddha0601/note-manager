package com.demo.keeptuit.service.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity for User table
 */
@Entity(name = "User")
public class UserDb extends Versioned {

    private static final int USERNAME_MAX_LENGTH = 15;
    private static final String USERNAME_INVALID_NAME = "Invalid username";
    private static final String USERNAME_REQUIRED_TITLE = "Username cannot be left blank";
    private static final String EMAIL_INVALID = "Must provide a valid email";

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private List<NoteDb> notes = new ArrayList<>();


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
     * Gets user name.
     *
     * @return the user name
     */
    @Size(max = USERNAME_MAX_LENGTH, message = USERNAME_INVALID_NAME)
    @NotBlank(message = USERNAME_REQUIRED_TITLE)
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName
     *         the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName
     *         the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    @Email(message = EMAIL_INVALID)
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email
     *         the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    @OneToMany(targetEntity = NoteDb.class, mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<NoteDb> getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes
     *         the notes
     */
    public void setNotes(List<NoteDb> notes) {
        this.notes = notes;
    }


    /**
     * With user name user db.
     *
     * @param userName
     *         the user name
     *
     * @return the user db
     */
    public UserDb withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * With first name user db.
     *
     * @param firstName
     *         the first name
     *
     * @return the user db
     */
    public UserDb withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * With last name user db.
     *
     * @param lastName
     *         the last name
     *
     * @return the user db
     */
    public UserDb withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * With email user db.
     *
     * @param email
     *         the email
     *
     * @return the user db
     */
    public UserDb withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * With notes user db.
     *
     * @param notes
     *         the notes
     *
     * @return the user db
     */
    public UserDb withNotes(List<NoteDb> notes) {
        this.notes = notes;
        return this;
    }
}
