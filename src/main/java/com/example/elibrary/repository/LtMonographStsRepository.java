package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographSts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtMonographStsRepository extends JpaRepository<LtMonographSts, Integer> {

    @Query("SELECT b FROM LtMonographSts b WHERE b.sts_id= :sts_id")
    LtMonographSts findByStsId(@Param("sts_id") int sts_id);
}
