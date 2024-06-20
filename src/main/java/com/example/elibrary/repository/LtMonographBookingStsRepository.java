package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographBookingSts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtMonographBookingStsRepository extends JpaRepository<LtMonographBookingSts, Integer> {

    @Query("SELECT b FROM LtMonographBookingSts b WHERE b.booking_sts_id= :booking_sts_id")
    LtMonographBookingSts findByStatusId(@Param("booking_sts_id") int booking_sts_id);
}
