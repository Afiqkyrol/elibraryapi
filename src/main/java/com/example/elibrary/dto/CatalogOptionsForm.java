package com.example.elibrary.dto;

import com.example.elibrary.entity.*;

import java.util.List;

public class CatalogOptionsForm {

    private List<LtMonographLanguage>  language;
    private List<LtMonographLoc> location;
    private List<LtMonographSubject> subject;
    private List<LtMonographType> type;
    private List<DtAuthor> author;
    private List<DtPublisher> publisher;

    public CatalogOptionsForm(){}

    public CatalogOptionsForm(List<LtMonographLanguage> language, List<LtMonographLoc> location, List<LtMonographSubject> subject, List<LtMonographType> type, List<DtAuthor> author, List<DtPublisher> publisher) {
        this.language = language;
        this.location = location;
        this.subject = subject;
        this.type = type;
        this.author = author;
        this.publisher = publisher;
    }

    public List<DtPublisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<DtPublisher> publisher) {
        this.publisher = publisher;
    }

    public List<DtAuthor> getAuthor() {
        return author;
    }

    public void setAuthor(List<DtAuthor> author) {
        this.author = author;
    }

    public List<LtMonographLanguage> getLanguage() {
        return language;
    }

    public void setLanguage(List<LtMonographLanguage> language) {
        this.language = language;
    }

    public List<LtMonographLoc> getLocation() {
        return location;
    }

    public void setLocation(List<LtMonographLoc> location) {
        this.location = location;
    }

    public List<LtMonographSubject> getSubject() {
        return subject;
    }

    public void setSubject(List<LtMonographSubject> subject) {
        this.subject = subject;
    }

    public List<LtMonographType> getType() {
        return type;
    }

    public void setType(List<LtMonographType> type) {
        this.type = type;
    }
}
