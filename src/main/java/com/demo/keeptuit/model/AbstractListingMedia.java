package com.demo.keeptuit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.Nonnull;
import java.net.URI;
import java.util.Collections;
import java.util.List;


public abstract class AbstractListingMedia<T> extends AbstractMediaType {
    protected List<T> items;

    public AbstractListingMedia() {
    }

    @Nonnull
    public List<T> getItems() {
        return this.items == null ? Collections.emptyList() : this.items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @JsonIgnore
    public boolean isEmpty() {
        return this.items == null || this.items.isEmpty();
    }

    public int count() {
        return this.isEmpty() ? 0 : this.items.size();
    }

    public AbstractListingMedia<T> withItems(List<T> items) {
        this.setItems(items);
        return this;
    }

    public abstract <T extends AbstractListingMedia> T getThis();
}