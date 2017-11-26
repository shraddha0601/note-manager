package com.demo.keeptuit.service.db.datalayer.api;

import com.demo.keeptuit.service.db.entity.UserDb;

/**
 * Interface for data layer operations for user
 */
public interface UserDataService {

    /**
     * Get the user with given username
     */
    UserDb getUser(String userName);

}
