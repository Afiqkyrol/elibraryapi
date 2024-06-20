package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographBorrowSts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtMonographBorrowStsRepository extends JpaRepository<LtMonographBorrowSts, Integer> {

    @Query("SELECT b FROM LtMonographBorrowSts b WHERE b.borrow_sts_id= :borrow_sts_id")
    LtMonographBorrowSts findByStatusId(@Param("borrow_sts_id") int borrow_sts_id);
}
