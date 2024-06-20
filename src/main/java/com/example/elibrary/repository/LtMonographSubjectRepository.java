package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographLoc;
import com.example.elibrary.entity.LtMonographSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtMonographSubjectRepository extends JpaRepository<LtMonographSubject, Integer> {

    @Query("SELECT b FROM LtMonographSubject b WHERE b.subject_id= :subject_id")
    LtMonographSubject findBySubjectId(@Param("subject_id") int subject_id);
}
