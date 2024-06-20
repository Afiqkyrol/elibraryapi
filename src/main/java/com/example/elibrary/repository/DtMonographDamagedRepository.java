package com.example.elibrary.repository;

import com.example.elibrary.entity.DtMonographDamaged;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DtMonographDamagedRepository extends JpaRepository<DtMonographDamaged, Integer> {

    @Query("SELECT b FROM DtMonographDamaged b WHERE b.damaged_id= :damaged_id")
    DtMonographDamaged findByDamagedId(@Param("damaged_id") int damaged_id);
}
