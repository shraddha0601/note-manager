package com.demo.keeptuit.service.model;

import java.beans.Transient;

public class NoteListMedia extends AbstractListingMedia<NoteMedia> {
    public static final String MEDIA_TYPE_LIST = MEDIA_TYPE_NAME_BASE + "note.list" + SERIALIZATION_FORMAT_JSON;

    @Override
    @Transient
    public NoteListMedia getThis() {
        return this;
    }
}
