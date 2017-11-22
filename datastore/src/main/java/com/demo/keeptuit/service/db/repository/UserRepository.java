package com.demo.keeptuit.service.db.repository;

import com.demo.keeptuit.service.db.entity.UserDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The jpa User repository.
 */
@Repository
public interface UserRepository extends CrudRepository<UserDb, Long> {

    /**
     * Find by user name.
     *
     * @param userName
     *         the user name
     *
     * @return the user db
     */
    UserDb findByUserName(String userName);
}
