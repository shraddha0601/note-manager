package com.demo.keeptuit.service.db.datalayer.api;

import com.demo.keeptuit.service.db.entity.UserDb;


public interface UserDataService {
    UserDb getUser(String userName);

}
