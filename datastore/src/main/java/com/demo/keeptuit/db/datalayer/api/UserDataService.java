package com.demo.keeptuit.db.datalayer.api;

import com.demo.keeptuit.db.entity.UserDb;


public interface UserDataService {
    UserDb getUser(String userName);

}
