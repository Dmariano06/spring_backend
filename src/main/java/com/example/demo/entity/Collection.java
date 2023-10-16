package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Collection{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<Tableau> tableaux;


    private String nom;

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

    public List<Tableau> getTableaux() {
        return tableaux;
    }

    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }

}
