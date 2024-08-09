package com.example.elibrary.repository;

import com.example.elibrary.entity.LtMonographLanguage;
import com.example.elibrary.entity.LtMonographSts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LtMonographLanguageRepository extends JpaRepository<LtMonographLanguage, Integer> {

    @Query("SELECT b FROM LtMonographLanguage b WHERE b.lang_id= :lang_id")
    LtMonographLanguage findByLangId(@Param("lang_id") int lang_id);

    @Query("SELECT b FROM LtMonographLanguage b WHERE b.lang_active= 1")
    List<LtMonographLanguage> findAllActive();
}
