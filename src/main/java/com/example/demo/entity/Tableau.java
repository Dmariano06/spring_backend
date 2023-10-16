package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tableaux")
public class Tableau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "collection_id")
    private Collection collection;



    public Collection getCollection() {
        return collection;
    }


    public void setCollection(Collection collection) {
        this.collection = collection;
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

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    private String taille;
    private double prix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
