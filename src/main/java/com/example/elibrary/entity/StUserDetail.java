package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "st_user_detail")
public class StUserDetail {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_guid")
    private String user_guid;

    @Column(name = "title_id")
    private String title_id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "old_ic_no")
    private String old_ic_no;

    @Column(name = "ic_no")
    private String ic_no;

    @Column(name = "passport_no")
    private String passport_no;

    @Column(name = "id_type")
    private Integer id_type;

    @Column(name = "others_id_no")
    private String others_id_no;

    @Column(name = "telephone_number")
    private String telephone_number;

    @Column(name = "mobile_phone_number")
    private String mobile_phone_number;

    @Column(name = "gender")
    private String gender;

    @Column(name = "status")
    private Integer status;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "address3")
    private String address3;

    @Column(name = "city")
    private String city;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "state_code")
    private String state_code;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "place_of_birth")
    private String place_of_birth;

    @Column(name = "state_of_birth")
    private String state_of_birth;

    @Column(name = "country_of_birth")
    private Integer country_of_birth;

    @Column(name = "birth_certificate_no")
    private String birth_certificate_no;

    @Column(name = "citizenship_status")
    private Integer citizenship_status;

    @Column(name = "citizenship_code")
    private String citizenship_code;

    @Column(name = "nationality")
    private Integer nationality;

    @Column(name = "race")
    private Integer race;

    @Column(name = "bumiputera_status")
    private String bumiputera_status;

    @Column(name = "religion")
    private Integer religion;

    @Column(name = "maritial_status")
    private Integer maritial_status;

    @Column(name = "blood_type")
    private Integer blood_type;

    public StUserDetail(){}

    public StUserDetail(Integer id, String user_guid, String title_id, String full_name, String old_ic_no, String ic_no, String passport_no, Integer id_type, String others_id_no, String telephone_number, String mobile_phone_number, String gender, Integer status, String address1, String address2, String address3, String city, String postcode, String state_code, String country_code, Date date_of_birth, String place_of_birth, String state_of_birth, Integer country_of_birth, String birth_certificate_no, Integer citizenship_status, String citizenship_code, Integer nationality, Integer race, String bumiputera_status, Integer religion, Integer maritial_status, Integer blood_type) {
        this.id = id;
        this.user_guid = user_guid;
        this.title_id = title_id;
        this.full_name = full_name;
        this.old_ic_no = old_ic_no;
        this.ic_no = ic_no;
        this.passport_no = passport_no;
        this.id_type = id_type;
        this.others_id_no = others_id_no;
        this.telephone_number = telephone_number;
        this.mobile_phone_number = mobile_phone_number;
        this.gender = gender;
        this.status = status;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.postcode = postcode;
        this.state_code = state_code;
        this.country_code = country_code;
        this.date_of_birth = date_of_birth;
        this.place_of_birth = place_of_birth;
        this.state_of_birth = state_of_birth;
        this.country_of_birth = country_of_birth;
        this.birth_certificate_no = birth_certificate_no;
        this.citizenship_status = citizenship_status;
        this.citizenship_code = citizenship_code;
        this.nationality = nationality;
        this.race = race;
        this.bumiputera_status = bumiputera_status;
        this.religion = religion;
        this.maritial_status = maritial_status;
        this.blood_type = blood_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_guid() {
        return user_guid;
    }

    public void setUser_guid(String user_guid) {
        this.user_guid = user_guid;
    }

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getOld_ic_no() {
        return old_ic_no;
    }

    public void setOld_ic_no(String old_ic_no) {
        this.old_ic_no = old_ic_no;
    }

    public String getIc_no() {
        return ic_no;
    }

    public void setIc_no(String ic_no) {
        this.ic_no = ic_no;
    }

    public String getPassport_no() {
        return passport_no;
    }

    public void setPassport_no(String passport_no) {
        this.passport_no = passport_no;
    }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public String getOthers_id_no() {
        return others_id_no;
    }

    public void setOthers_id_no(String others_id_no) {
        this.others_id_no = others_id_no;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getMobile_phone_number() {
        return mobile_phone_number;
    }

    public void setMobile_phone_number(String mobile_phone_number) {
        this.mobile_phone_number = mobile_phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getState_of_birth() {
        return state_of_birth;
    }

    public void setState_of_birth(String state_of_birth) {
        this.state_of_birth = state_of_birth;
    }

    public Integer getCountry_of_birth() {
        return country_of_birth;
    }

    public void setCountry_of_birth(Integer country_of_birth) {
        this.country_of_birth = country_of_birth;
    }

    public String getBirth_certificate_no() {
        return birth_certificate_no;
    }

    public void setBirth_certificate_no(String birth_certificate_no) {
        this.birth_certificate_no = birth_certificate_no;
    }

    public Integer getCitizenship_status() {
        return citizenship_status;
    }

    public void setCitizenship_status(Integer citizenship_status) {
        this.citizenship_status = citizenship_status;
    }

    public String getCitizenship_code() {
        return citizenship_code;
    }

    public void setCitizenship_code(String citizenship_code) {
        this.citizenship_code = citizenship_code;
    }

    public Integer getNationality() {
        return nationality;
    }

    public void setNationality(Integer nationality) {
        this.nationality = nationality;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public String getBumiputera_status() {
        return bumiputera_status;
    }

    public void setBumiputera_status(String bumiputera_status) {
        this.bumiputera_status = bumiputera_status;
    }

    public Integer getReligion() {
        return religion;
    }

    public void setReligion(Integer religion) {
        this.religion = religion;
    }

    public Integer getMaritial_status() {
        return maritial_status;
    }

    public void setMaritial_status(Integer maritial_status) {
        this.maritial_status = maritial_status;
    }

    public Integer getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(Integer blood_type) {
        this.blood_type = blood_type;
    }

    @Override
    public String toString() {
        return "StUserDetail{" +
                "id=" + id +
                ", user_guid='" + user_guid + '\'' +
                ", title_id='" + title_id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", old_ic_no='" + old_ic_no + '\'' +
                ", ic_no='" + ic_no + '\'' +
                ", passport_no='" + passport_no + '\'' +
                ", id_type=" + id_type +
                ", others_id_no='" + others_id_no + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", mobile_phone_number='" + mobile_phone_number + '\'' +
                ", gender='" + gender + '\'' +
                ", status=" + status +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", state_code='" + state_code + '\'' +
                ", country_code='" + country_code + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", place_of_birth='" + place_of_birth + '\'' +
                ", state_of_birth='" + state_of_birth + '\'' +
                ", country_of_birth=" + country_of_birth +
                ", birth_certificate_no='" + birth_certificate_no + '\'' +
                ", citizenship_status=" + citizenship_status +
                ", citizenship_code='" + citizenship_code + '\'' +
                ", nationality=" + nationality +
                ", race=" + race +
                ", bumiputera_status='" + bumiputera_status + '\'' +
                ", religion=" + religion +
                ", maritial_status=" + maritial_status +
                ", blood_type=" + blood_type +
                '}';
    }
}
