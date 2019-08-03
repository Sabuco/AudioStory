package com.enfocat.audiolibro.models;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;

@Entity
@Table(name = "stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "category")
    private String category;

    @Column(name = "cover")
    private String cover;

    @Column(name = "createdDate")
    private String createdDate;

    @Column(name = "updatedDate")
    private String updatedDate;

    @Column (name = "challengesid", nullable = true)
    private long challengesid;



    @OneToMany(mappedBy = "story")
    private List<Chapter> chapters;

    public Story() {
    }

    public void setCover(String cover) {
        this.cover = "/uploads/" + cover;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCover() {
        return cover;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = new SimpleDateFormat("yyyy-MM-dd").format(createdDate);
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = new SimpleDateFormat("yyyy-MM-dd").format(updatedDate);
    }

    public long getChallengesid() {
        return challengesid;
    }

    public void setChallengesid(long challengesid) {
        this.challengesid = challengesid;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    

}