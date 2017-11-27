package com.demo.keeptuit.service.rest.model;

import java.beans.Transient;

/**
 * Listing media type for note
 */
public class NoteListMedia extends AbstractListingMedia<NoteMedia> {
    public static final String MEDIA_TYPE_LIST = MEDIA_TYPE_NAME_BASE + "note.list" + SERIALIZATION_FORMAT_JSON;

    @Override
    @Transient
    public NoteListMedia getThis() {
        return this;
    }
}
