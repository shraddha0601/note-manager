package com.demo.keeptuit.db.datalayer.api;

import com.demo.keeptuit.db.entity.UserDb;
import com.sun.tools.javap.TypeAnnotationWriter.Note;

import java.util.List;

public interface UserDataService {
    UserDb getUser(String userName);

}
