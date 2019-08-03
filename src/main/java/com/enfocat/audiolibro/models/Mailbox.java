package com.enfocat.audiolibro.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
/**
 * Mailbox
 */

@Entity
@Table(name="mailbox") // nombre de la tabla 
public class Mailbox {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Nombre requerido")
    private String content;
    private String reason;
    private long  usersid;
  
    
    //CONSTRUCTOR PELAT
    public Mailbox(){}

   
    // CONSTRUCTOR SIN ID
    public Mailbox(String content, String reason, long usersid) {
        this.id=0;
        this.content = content;
        this.reason = reason;
        this.usersid=usersid;
    }
   
    //CONSTRUCTOR CON ID
    public Mailbox(long id, String content, String reason, long usersid) {
        this.id = id;
        this.content = content;
        this.reason = reason;
        this.usersid=usersid;
    }

    @Override
    public String toString() {
        return "Mailbox [content=" + content + ", id=" + id + ", reason=" + reason + ", userid=" + usersid + "]";
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getUsersid() {
        return usersid;
    }

    public void setUsersid(long usersid) {
        this.usersid = usersid;
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