package com.demo.keeptuit.db.repository;

import com.demo.keeptuit.db.entity.NoteDb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends CrudRepository<NoteDb, Long> {
}
