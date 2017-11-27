package com.demo.keeptuit.service.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;


/**
 * The type Abstract listing media.
 *
 * @param <T>
 *         the type parameter
 */
public abstract class AbstractListingMedia<T> extends AbstractMediaType {
    /**
     * The Items.
     */
    protected List<T> items;

    /**
     * Instantiates a new Abstract listing media.
     */
    public AbstractListingMedia() {
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    @Nonnull
    public List<T> getItems() {
        return this.items == null ? Collections.emptyList() : this.items;
    }

    /**
     * Sets items.
     *
     * @param items
     *         the items
     */
    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    @JsonIgnore
    public boolean isEmpty() {
        return this.items == null || this.items.isEmpty();
    }

    /**
     * Count int.
     *
     * @return the int
     */
    public int count() {
        return this.isEmpty() ? 0 : this.items.size();
    }

    /**
     * With items abstract listing media.
     *
     * @param items
     *         the items
     *
     * @return the abstract listing media
     */
    public AbstractListingMedia<T> withItems(List<T> items) {
        this.setItems(items);
        return this;
    }

    /**
     * Gets this.
     *
     * @param <T>
     *         the type parameter
     *
     * @return the this
     */
    public abstract <T extends AbstractListingMedia> T getThis();
}