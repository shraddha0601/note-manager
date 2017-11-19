package com.demo.keeptuit.db.repository;

import com.demo.keeptuit.db.entity.NoteDb;
import com.demo.keeptuit.db.entity.UserDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDb, Long> {
}
