package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographSts;
import com.example.elibrary.entity.LtMonographType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtMonographTypeRepository extends JpaRepository<LtMonographType,Integer> {

    @Query("SELECT b FROM LtMonographType b WHERE b.type_id= :type_id")
    LtMonographType findByTypeId(@Param("type_id") int type_id);
}
