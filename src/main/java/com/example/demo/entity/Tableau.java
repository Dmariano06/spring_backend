package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tableaux")
public class Tableau {

    @Column(name="nom")
    private String nom;

    @Column(name="image")
    private String image;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name="prix")
    private Long prix;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name="collection")
    private String collection;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public Number getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
