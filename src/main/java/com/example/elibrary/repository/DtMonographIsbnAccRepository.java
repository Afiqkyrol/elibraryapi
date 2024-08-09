package com.example.elibrary.repository;

import com.example.elibrary.entity.DtMonographHistoryStatus;
import com.example.elibrary.entity.DtMonographIsbnAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DtMonographIsbnAccRepository extends JpaRepository<DtMonographIsbnAcc, Integer> {

    @Query("SELECT b FROM DtMonographIsbnAcc b WHERE b.isbn_no= :isbn_no")
    DtMonographIsbnAcc findByIsbnNo(@Param("isbn_no") String isbn_no);
}
