package com.example.elibrary.repository;

import com.example.elibrary.entity.StUser;
import com.example.elibrary.entity.StUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StUserRoleRepository extends JpaRepository<StUserRole, Integer> {

    @Query("SELECT b FROM StUserRole b where b.user_guid = :guid AND module_id = :module_id")
    StUserRole getUserRoleByGuidAndModuleId(@Param("guid") String guid, @Param("module_id") int module_id);
}
