package com.example.elibrary.repository;

import com.example.elibrary.entity.StUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StUserRepository extends JpaRepository<StUser, Integer> {

    @Query("SELECT b FROM StUser b where b.guid = :guid")
    StUser getUserByGuid(@Param("guid") String guid);
}
