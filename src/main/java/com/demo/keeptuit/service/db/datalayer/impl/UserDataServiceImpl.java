package com.demo.keeptuit.service.db.datalayer.impl;

import com.demo.keeptuit.service.db.datalayer.api.UserDataService;
import com.demo.keeptuit.service.db.entity.UserDb;
import com.demo.keeptuit.service.db.exception.UserNotFoundException;
import com.demo.keeptuit.service.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Implementation of {@code UserDataService}
 */
@ParametersAreNonnullByDefault
@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDb getUser(String userName) {
        UserDb user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
