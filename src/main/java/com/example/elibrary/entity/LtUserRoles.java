package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LtUserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private int roles_id;

    @Column(name = "roles_type")
    private String roles_type;

    @Column(name = "roles_description")
    private String roles_description;

    @Column(name = "roles_active")
    private int roles_active;

    @Column(name = "roles_created_at")
    private Date roles_created_at;

    @Column(name = "roles_created_by")
    private String roles_created_by;

    public LtUserRoles(){}

    public LtUserRoles(String roles_type, String roles_description, int roles_active, Date roles_created_at, String roles_created_by) {
        this.roles_type = roles_type;
        this.roles_description = roles_description;
        this.roles_active = roles_active;
        this.roles_created_at = roles_created_at;
        this.roles_created_by = roles_created_by;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public String getRoles_type() {
        return roles_type;
    }

    public void setRoles_type(String roles_type) {
        this.roles_type = roles_type;
    }

    public String getRoles_description() {
        return roles_description;
    }

    public void setRoles_description(String roles_description) {
        this.roles_description = roles_description;
    }

    public int getRoles_active() {
        return roles_active;
    }

    public void setRoles_active(int roles_active) {
        this.roles_active = roles_active;
    }

    public Date getRoles_created_at() {
        return roles_created_at;
    }

    public void setRoles_created_at(Date roles_created_at) {
        this.roles_created_at = roles_created_at;
    }

    public String getRoles_created_by() {
        return roles_created_by;
    }

    public void setRoles_created_by(String roles_created_by) {
        this.roles_created_by = roles_created_by;
    }
}
