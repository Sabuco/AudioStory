package com.enfocat.audiolibro.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "chapters")

public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Capitulo vacio")
    @Column(columnDefinition="TEXT")
    private String content;
    private String title;
    private long chapternum;
    private String fileaudio;

    @ManyToOne
    @JoinColumn(name = "usersid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "storiesid")
    private Story story;
/*
    @OneToMany(mappedBy = "chapter")
    private List<Comments> comments;
*/
    // CONSTRUCTOR PELAT
    public Chapter() {
    }

    @Override
    public String toString() {
        return String.format("Cap %d", this.chapternum);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getChapternum() {
        return chapternum;
    }

    public void setChapternum(long chapternum) {
        this.chapternum = chapternum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public String getFileaudio() {
        return fileaudio;
    }

    public void setFileaudio(String fileaudio) {
        this.fileaudio = "/uploads/" + fileaudio;
    }

 

    

}