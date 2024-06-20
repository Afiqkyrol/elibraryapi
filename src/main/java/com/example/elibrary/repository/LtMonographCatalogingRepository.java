package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographCataloging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtMonographCatalogingRepository extends JpaRepository<LtMonographCataloging, Integer> {

    @Query("SELECT b FROM LtMonographCataloging b WHERE b.cataloging_id = :cataloging_id ")
    LtMonographCataloging findByCatalogingId(@Param("cataloging_id") int cataloging_id );
}
