package com.enfocat.audiolibro.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/*
text content
int valoracion
int user_id
int chapter_id
*/
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

 
    @Column(name = "content")
    private String content;
   // private long commentnum;

    @Column(name = "valoracion")
    private int valoracion;

    @Column(name = "chaptersid")
    private long chaptersid;

    @Column(name = "usersid")
    private long usersid;

    @Column(name = "name")
    private String name;

    /*
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chapterId")
    private Chapter chapter;

*/
    

    
    // EMPTY CONSTRUCTOR
    public Comments() {
    }

    @Override
    public String toString() {
        return String.format("Comentario %d", this.id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    
    public long getChaptersid() {
        return chaptersid;
    }

    public void setChaptersid(long chaptersid) {
        this.chaptersid = chaptersid;
    }

    public long getUsersid() {
        return usersid;
    }

    public void setUsersid(long usersid) {
        this.usersid = usersid;
    }

}