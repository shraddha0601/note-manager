package com.demo.keeptuit.service.db.repository;

import com.demo.keeptuit.service.db.entity.UserDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDb, Long> {

    UserDb findByUserName(String userName);
}
