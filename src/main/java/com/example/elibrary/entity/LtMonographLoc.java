package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lt_monograph_loc")
public class LtMonographLoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
    private int loc_id;

    @Column(name = "loc_location")
    private String loc_location;

    @Column(name = "loc_wilayah")
    private String loc_wilayah;

    @Column(name = "loc_location_code")
    private String loc_location_code;

    @Column(name = "loc_telephone")
    private String loc_telephone;

    @Column(name = "loc_address")
    private String loc_address;

    @Column(name = "loc_created_at")
    private Date loc_created_at;

    @Column(name = "loc_created_by")
    private String loc_created_by;

    public LtMonographLoc(){}

    public LtMonographLoc(String loc_location, String loc_wilayah, String loc_location_code, String loc_telephone, String loc_address, Date loc_created_at, String loc_created_by) {
        this.loc_location = loc_location;
        this.loc_wilayah = loc_wilayah;
        this.loc_location_code = loc_location_code;
        this.loc_telephone = loc_telephone;
        this.loc_address = loc_address;
        this.loc_created_at = loc_created_at;
        this.loc_created_by = loc_created_by;
    }

    public int getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }

    public String getLoc_location() {
        return loc_location;
    }

    public void setLoc_location(String loc_location) {
        this.loc_location = loc_location;
    }

    public String getLoc_wilayah() {
        return loc_wilayah;
    }

    public void setLoc_wilayah(String loc_wilayah) {
        this.loc_wilayah = loc_wilayah;
    }

    public String getLoc_location_code() {
        return loc_location_code;
    }

    public void setLoc_location_code(String loc_location_code) {
        this.loc_location_code = loc_location_code;
    }

    public String getLoc_telephone() {
        return loc_telephone;
    }

    public void setLoc_telephone(String loc_telephone) {
        this.loc_telephone = loc_telephone;
    }

    public String getLoc_address() {
        return loc_address;
    }

    public void setLoc_address(String loc_address) {
        this.loc_address = loc_address;
    }

    public Date getLoc_created_at() {
        return loc_created_at;
    }

    public void setLoc_created_at(Date loc_created_at) {
        this.loc_created_at = loc_created_at;
    }

    public String getLoc_created_by() {
        return loc_created_by;
    }

    public void setLoc_created_by(String loc_created_by) {
        this.loc_created_by = loc_created_by;
    }

    @Override
    public String toString() {
        return "LtMonographLoc{" +
                "loc_id=" + loc_id +
                ", loc_location='" + loc_location + '\'' +
                ", loc_wilayah='" + loc_wilayah + '\'' +
                ", loc_location_code='" + loc_location_code + '\'' +
                ", loc_telephone='" + loc_telephone + '\'' +
                ", loc_address='" + loc_address + '\'' +
                ", loc_created_at=" + loc_created_at +
                ", loc_created_by='" + loc_created_by + '\'' +
                '}';
    }
}
