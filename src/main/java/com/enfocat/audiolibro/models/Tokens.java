package com.enfocat.audiolibro.models;

//import java.sql.Date;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Tokens
 */
@Entity
@Table(name="tokens") // nombre de la tabla 
public class Tokens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

  
    private String token;
    private Date creationDate;
    private int  hours;
    private int userid;
  
    
    //CONSTRUCTOR PELAT
    public Tokens(){}

   
    // CONSTRUCTOR SIN ID
    public Tokens(String token, String creationDate, int hours, int userid) {
        this.id=0;
        this.token = token;
        try {
            this.creationDate =  new SimpleDateFormat("yyyy-MM-dd").parse(creationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        this.hours=hours;
        this.userid=userid;
    }

   
    //CONSTRUCTOR CON ID
    public Tokens(long id,String token, String creationDate, int hours, int userid) {
        this.id=id;
        this.token = token;
        try {
            this.creationDate =  new SimpleDateFormat("yyyy-MM-dd").parse(creationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        this.hours=hours;
        this.userid=userid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

  
    

/*
    public String getUrlfotoPath(){
        String base = "/contactos/uploads/";
        if (this.urlfoto==null || this.urlfoto.length()==0) {
            return base + "nofoto.png";
        } else {
            return base + this.urlfoto;
        }
    }*/



}