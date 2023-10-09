package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="collection")
public class Collection
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "Tableaux")
    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<Tableau> tableaux;


    public List<Tableau> getTableaux() {
        return tableaux;
    }

    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }

    public Long getNbr_tableaux() {
        return nbr_tableaux;
    }

    public void setNbr_tableaux(Long nbr_tableaux) {
        this.nbr_tableaux = nbr_tableaux;
    }

    @Column(name = "nbr_tableaux")
    private Long nbr_tableaux;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
