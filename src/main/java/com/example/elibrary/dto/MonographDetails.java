package com.example.elibrary.dto;

import com.example.elibrary.entity.*;

import java.util.List;

public class MonographDetails {

    private DtMonographRegistration monograph;
    private DtPublisher publisher;
    private DtAuthor author;
    private LtMonographLanguage language;

    private LtMonographSts status;

    private LtMonographType type;

    private LtMonographLoc location;

    private LtMonographSubject subject;

    private List<LtMonographCataloging> cataloging;

    private List<DtMonographCatalogRegistration> catalog;

    public MonographDetails(){}

    public MonographDetails(DtMonographRegistration monograph,
                            List<DtMonographCatalogRegistration> catalog,
                            DtPublisher publisher,
                            DtAuthor author,
                            LtMonographLanguage language,
                            LtMonographSts status,
                            LtMonographType type,
                            LtMonographLoc location,
                            LtMonographSubject subject,
                            List<LtMonographCataloging> cataloging) {
        this.monograph = monograph;
        this.catalog = catalog;
        this.publisher = publisher;
        this.author = author;
        this.language = language;
        this.status = status;
        this.type = type;
        this.location = location;
        this.subject = subject;
        this.cataloging = cataloging;
    }

    public List<DtMonographCatalogRegistration> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<DtMonographCatalogRegistration>  catalog) {
        this.catalog = catalog;
    }

    public List<LtMonographCataloging> getCataloging() {
        return cataloging;
    }

    public void setCataloging(List<LtMonographCataloging> cataloging) {
        this.cataloging = cataloging;
    }

    public LtMonographSubject getSubject() {
        return subject;
    }

    public void setSubject(LtMonographSubject subject) {
        this.subject = subject;
    }

    public LtMonographLoc getLocation() {
        return location;
    }

    public void setLocation(LtMonographLoc location) {
        this.location = location;
    }

    public LtMonographType getType() {
        return type;
    }

    public void setType(LtMonographType type) {
        this.type = type;
    }

    public LtMonographSts getStatus() {
        return status;
    }

    public void setStatus(LtMonographSts status) {
        this.status = status;
    }

    public LtMonographLanguage getLanguage() {
        return language;
    }

    public void setLanguage(LtMonographLanguage language) {
        this.language = language;
    }

    public DtMonographRegistration getMonograph() {
        return monograph;
    }

    public void setMonograph(DtMonographRegistration monograph) {
        this.monograph = monograph;
    }

    public DtPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(DtPublisher publisher) {
        this.publisher = publisher;
    }

    public DtAuthor getAuthor() {
        return author;
    }

    public void setAuthor(DtAuthor author) {
        this.author = author;
    }
}
