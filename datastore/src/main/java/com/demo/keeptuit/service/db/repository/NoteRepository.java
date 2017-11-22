package com.demo.keeptuit.service.db.repository;

import com.demo.keeptuit.service.db.entity.NoteDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The jpa Note repository.
 */
@Repository
public interface NoteRepository extends CrudRepository<NoteDb, Long> {
}
