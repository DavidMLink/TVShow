package com.codingdojo.templatelogreg.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table(name="shows")
public class Show {
    //PrimaryKey
    @Id
    //PrimaryKey AutoGeneration
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 1, max = 40)
    private String title;

    @Size(min = 1, max = 10)
    private String network;

    private Double rating;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    // CONSTRUCTORS 
    public Show() { 
    } 
    // creates object 
    public Show(String title,  String network,  Double rating ){ 
        this.title = title; 
        this.network = network; 
        this.rating = rating; 
    } 

    // updates object
    public Show(Long id, String title, String network, Double rating ){ 
        this.id = id; 
        this.title = title; 
        this.network = network; 
        this.rating = rating; 
    } 

    //END OF CONSTRUCTORS 

    @PrePersist 
    protected void onCreate(){ 
        this.createdAt = new Date(); 
    } 
    @PreUpdate 
    protected void onUpdate(){ 
        this.updatedAt = new Date(); 
    } 
} 
