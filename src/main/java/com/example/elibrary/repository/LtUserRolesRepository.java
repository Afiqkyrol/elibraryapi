package com.example.elibrary.repository;

import com.example.elibrary.entity.LtUserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LtUserRolesRepository extends JpaRepository<LtUserRoles, Integer> {

    @Query("SELECT roles_type FROM LtUserRoles b WHERE b.roles_id= :roles_id")
    public String findRoleById(@Param("roles_id") int roles_id);

    @Query("SELECT b FROM LtUserRoles b WHERE b.roles_id= :roles_id")
    public LtUserRoles findByRoleId(@Param("roles_id") int roles_id);
}
