package com.example.elibrary.repository;

import com.example.elibrary.entity.DtAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DtAuthorRepository extends JpaRepository<DtAuthor, Integer> {

    @Query("SELECT b FROM DtAuthor b WHERE b.author_id= :author_id")
    DtAuthor findByAuthorId(@Param("author_id") int author_id);

}
