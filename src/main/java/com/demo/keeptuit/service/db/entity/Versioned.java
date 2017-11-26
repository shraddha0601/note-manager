package com.demo.keeptuit.service.db.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * Base class for database entities
 */
public class Versioned {
    private Long version;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    /**
     * Gets version.
     *
     * @return the version
     */
    @Version
    public Long getVersion() {
        return version;
    }

    /**
     * Sets version.
     *
     * @param version
     *         the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets created date.
     *
     * @param createdDate
     *         the created date
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets modified date.
     *
     * @return the modified date
     */
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets modified date.
     *
     * @param modifiedDate
     *         the modified date
     */
    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
