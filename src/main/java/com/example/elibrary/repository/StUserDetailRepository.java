package com.example.elibrary.repository;

import com.example.elibrary.entity.StUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StUserDetailRepository extends JpaRepository<StUserDetail, Integer> {

    @Query("SELECT b FROM StUserDetail b where b.user_guid = :user_guid")
    StUserDetail getUserDetailByGuid(@Param("user_guid") String user_guid);

}
