package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table()
public class DtMonographRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id")
    private int reg_id;

    @Column(name = "reg_title")
    private String reg_title;

    @Column(name = "reg_description")
    private String reg_description;

    @Column(name = "reg_type")
    private int reg_type;

    @Column(name = "reg_author_id")
    private int reg_author_id;

    @Column(name = "reg_publisher_id")
    private int reg_publisher_id;

    @Column(name = "reg_location_id")
    private int reg_location_id;

    @Column(name = "reg_mono_subject")
    private int reg_mono_subject;

    @Column(name = "reg_mono_lang")
    private int reg_mono_lang;

    @Column(name = "reg_mono_cat")
    private int reg_mono_cat;

    @Column(name = "reg_control_no")
    private String reg_control_no;

    @Column(name = "copy")
    private int copy;

    @Column(name = "reg_ISBN")
    private String reg_ISBN;

    @Column(name = "reg_collation")
    private String reg_collation;

    @Column(name = "reg_ddc_call_no")
    private String reg_ddc_call_no;

    @Column(name = "reg_catalog_notes")
    private String reg_catalog_notes;

    @Column(name = "reg_accession_no")
    private String reg_accession_no;

    @Column(name = "reg_qty")
    private int reg_qty;

    @Column(name = "reg_featured")
    private String reg_featured;

    @Column(name = "reg_registered_by")
    private String reg_registered_by;

    @Column(name = "reg_publish")
    private String reg_publish;

    @Column(name = "reg_ebook")
    private String reg_ebook;

    @Column(name = "reg_status")
    private int reg_status;

    @Column(name = "reg_created_date")
    private Date reg_created_date;

    @Column(name = "reg_image_link")
    private String reg_image_link;

    @Column(name = "reg_ebook_path")
    private String reg_ebook_path;

    @Column(name = "reg_download_count")
    private Integer reg_download_count;

    public DtMonographRegistration(){}

    public DtMonographRegistration(String reg_title, String reg_description, int reg_type, int reg_author_id, int reg_publisher_id, int reg_location_id, int reg_mono_subject, int reg_mono_lang, int reg_mono_cat, String reg_control_no, int copy, String reg_ISBN, String reg_collation, String reg_ddc_call_no, String reg_catalog_notes, String reg_accession_no, int reg_qty, String reg_featured, String reg_registered_by, String reg_publish, String reg_ebook, int reg_status, Date reg_created_date, String reg_image_link, String reg_ebook_path, Integer reg_download_count) {
        this.reg_title = reg_title;
        this.reg_description = reg_description;
        this.reg_type = reg_type;
        this.reg_author_id = reg_author_id;
        this.reg_publisher_id = reg_publisher_id;
        this.reg_location_id = reg_location_id;
        this.reg_mono_subject = reg_mono_subject;
        this.reg_mono_lang = reg_mono_lang;
        this.reg_mono_cat = reg_mono_cat;
        this.reg_control_no = reg_control_no;
        this.copy = copy;
        this.reg_ISBN = reg_ISBN;
        this.reg_collation = reg_collation;
        this.reg_ddc_call_no = reg_ddc_call_no;
        this.reg_catalog_notes = reg_catalog_notes;
        this.reg_accession_no = reg_accession_no;
        this.reg_qty = reg_qty;
        this.reg_featured = reg_featured;
        this.reg_registered_by = reg_registered_by;
        this.reg_publish = reg_publish;
        this.reg_ebook = reg_ebook;
        this.reg_status = reg_status;
        this.reg_created_date = reg_created_date;
        this.reg_image_link = reg_image_link;
        this.reg_ebook_path = reg_ebook_path;
        this.reg_download_count = reg_download_count;
    }

    public Integer getReg_download_count() {
        return reg_download_count;
    }

    public void setReg_download_count(Integer reg_download_count) {
        this.reg_download_count = reg_download_count;
    }

    public String getReg_ebook_path() {
        return reg_ebook_path;
    }

    public void setReg_ebook_path(String reg_ebook_path) {
        this.reg_ebook_path = reg_ebook_path;
    }

    public int getReg_type() {
        return reg_type;
    }

    public void setReg_type(int reg_type) {
        this.reg_type = reg_type;
    }

    public String getReg_description() {
        return reg_description;
    }

    public void setReg_description(String reg_description) {
        this.reg_description = reg_description;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public int getReg_id() {
        return reg_id;
    }

    public void setReg_id(int reg_id) {
        this.reg_id = reg_id;
    }

    public String getReg_title() {
        return reg_title;
    }

    public void setReg_title(String reg_title) {
        this.reg_title = reg_title;
    }

    public int getReg_author_id() {
        return reg_author_id;
    }

    public void setReg_author_id(int reg_author_id) {
        this.reg_author_id = reg_author_id;
    }

    public int getReg_publisher_id() {
        return reg_publisher_id;
    }

    public void setReg_publisher_id(int reg_publisher_id) {
        this.reg_publisher_id = reg_publisher_id;
    }

    public int getReg_location_id() {
        return reg_location_id;
    }

    public void setReg_location_id(int reg_location_id) {
        this.reg_location_id = reg_location_id;
    }

    public int getReg_mono_subject() {
        return reg_mono_subject;
    }

    public void setReg_mono_subject(int reg_mono_subject) {
        this.reg_mono_subject = reg_mono_subject;
    }

    public int getReg_mono_lang() {
        return reg_mono_lang;
    }

    public void setReg_mono_lang(int reg_mono_lang) {
        this.reg_mono_lang = reg_mono_lang;
    }

    public int getReg_mono_cat() {
        return reg_mono_cat;
    }

    public void setReg_mono_cat(int reg_mono_cat) {
        this.reg_mono_cat = reg_mono_cat;
    }

    public String getReg_control_no() {
        return reg_control_no;
    }

    public void setReg_control_no(String reg_control_no) {
        this.reg_control_no = reg_control_no;
    }

    public String getReg_ISBN() {
        return reg_ISBN;
    }

    public void setReg_ISBN(String reg_ISBN) {
        this.reg_ISBN = reg_ISBN;
    }

    public String getReg_collation() {
        return reg_collation;
    }

    public void setReg_collation(String reg_collation) {
        this.reg_collation = reg_collation;
    }

    public String getReg_ddc_call_no() {
        return reg_ddc_call_no;
    }

    public void setReg_ddc_call_no(String reg_ddc_call_no) {
        this.reg_ddc_call_no = reg_ddc_call_no;
    }

    public String getReg_catalog_notes() {
        return reg_catalog_notes;
    }

    public void setReg_catalog_notes(String reg_catalog_noted) {
        this.reg_catalog_notes = reg_catalog_noted;
    }

    public String getReg_accession_no() {
        return reg_accession_no;
    }

    public void setReg_accession_no(String reg_accession_no) {
        this.reg_accession_no = reg_accession_no;
    }

    public int getReg_qty() {
        return reg_qty;
    }

    public void setReg_qty(int reg_qty) {
        this.reg_qty = reg_qty;
    }

    public String getReg_featured() {
        return reg_featured;
    }

    public void setReg_featured(String reg_featured) {
        this.reg_featured = reg_featured;
    }

    public String getReg_registered_by() {
        return reg_registered_by;
    }

    public void setReg_registered_by(String reg_registered_by) {
        this.reg_registered_by = reg_registered_by;
    }

    public String getReg_publish() {
        return reg_publish;
    }

    public void setReg_publish(String reg_publish) {
        this.reg_publish = reg_publish;
    }

    public String getReg_ebook() {
        return reg_ebook;
    }

    public void setReg_ebook(String reg_ebook) {
        this.reg_ebook = reg_ebook;
    }

    public int getReg_status() {
        return reg_status;
    }

    public void setReg_status(int reg_status) {
        this.reg_status = reg_status;
    }

    public Date getReg_created_date() {
        return reg_created_date;
    }

    public void setReg_created_date(Date reg_created_date) {
        this.reg_created_date = reg_created_date;
    }

    public String getReg_image_link() {
        return reg_image_link;
    }

    public void setReg_image_link(String reg_image_link) {
        this.reg_image_link = reg_image_link;
    }

    @Override
    public String toString() {
        return "DtMonographRegistration{" +
                "reg_id=" + reg_id +
                ", reg_title='" + reg_title + '\'' +
                ", reg_description='" + reg_description + '\'' +
                ", reg_type=" + reg_type +
                ", reg_author_id=" + reg_author_id +
                ", reg_publisher_id=" + reg_publisher_id +
                ", reg_location_id=" + reg_location_id +
                ", reg_mono_subject=" + reg_mono_subject +
                ", reg_mono_lang=" + reg_mono_lang +
                ", reg_mono_cat=" + reg_mono_cat +
                ", reg_control_no='" + reg_control_no + '\'' +
                ", copy=" + copy +
                ", reg_ISBN='" + reg_ISBN + '\'' +
                ", reg_collation='" + reg_collation + '\'' +
                ", reg_ddc_call_no='" + reg_ddc_call_no + '\'' +
                ", reg_catalog_notes='" + reg_catalog_notes + '\'' +
                ", reg_accession_no='" + reg_accession_no + '\'' +
                ", reg_qty=" + reg_qty +
                ", reg_featured='" + reg_featured + '\'' +
                ", reg_registered_by='" + reg_registered_by + '\'' +
                ", reg_publish='" + reg_publish + '\'' +
                ", reg_ebook='" + reg_ebook + '\'' +
                ", reg_status=" + reg_status +
                ", reg_created_date=" + reg_created_date +
                ", reg_image_link='" + reg_image_link + '\'' +
                '}';
    }
}
