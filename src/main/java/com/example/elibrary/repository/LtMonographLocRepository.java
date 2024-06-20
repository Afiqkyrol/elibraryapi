package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographLanguage;
import com.example.elibrary.entity.LtMonographLoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtMonographLocRepository extends JpaRepository<LtMonographLoc, Integer> {

    @Query("SELECT b FROM LtMonographLoc b WHERE b.loc_id= :loc_id")
    LtMonographLoc findByLocId(@Param("loc_id") int loc_id);
}
