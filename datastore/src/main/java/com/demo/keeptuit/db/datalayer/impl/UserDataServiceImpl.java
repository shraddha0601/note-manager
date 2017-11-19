package com.demo.keeptuit.db.datalayer.impl;

import com.demo.keeptuit.db.datalayer.api.UserDataService;
import com.demo.keeptuit.db.entity.UserDb;
import com.demo.keeptuit.db.repository.UserRepository;
import com.sun.tools.javap.TypeAnnotationWriter.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDb getUser(String userName) {
        return userRepository.findByUserName(userName);
    }
}
