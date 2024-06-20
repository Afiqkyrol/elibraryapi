package com.example.elibrary.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="userid")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="roles")
    private int role_id;

    @Column(name="email")
    private String email;

    @Column(name="reg_date")
    private Date regDate;

    ////////////////

    @Column(name="phone_no")
    private String phoneNo;

    @Column(name="address1")
    private String address1;

    @Column(name="address2")
    private String address2;

    @Column(name="state")
    private String state;

    @Column(name="approved")
    private String approved;

    @Column(name="approved_by")
    private String approvedBy;

    @Column(name="approved_date")
    private Date approvedDate;

    @Enumerated(value = EnumType.STRING)
    Role role;

    ///////////////////////////

    public User(){}

    public User(String fullName, String username, String password, int role_id, String email, Date regDate, String phoneNo, String address1, String address2, String state, String approved, String approvedBy, Date approvedDate, Role role) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.email = email;
        this.regDate = regDate;
        this.phoneNo = phoneNo;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.approved = approved;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role_id=" + role_id +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", phoneNo='" + phoneNo + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", state='" + state + '\'' +
                ", approved='" + approved + '\'' +
                ", approvedBy='" + approvedBy + '\'' +
                ", approvedDate=" + approvedDate +
                ", role=" + role +
                '}';
    }
}
