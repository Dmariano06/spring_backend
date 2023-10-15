package com.example.demo.service;

import com.example.demo.entity.Tableau;
import com.example.demo.repository.TableauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableauService {
    @Autowired
    private TableauRepository tableauRepository;

    public Optional<Tableau> findById(Long id) {
        return tableauRepository.findById(id);
    }

    public void deleteById(Long id) {
        tableauRepository.deleteById(id);
    }

    public boolean isTableauNomExists(String nom) {
        return tableauRepository.existsByNom(nom);
    }
    public TableauService(TableauRepository tableauRepository) {
        this.tableauRepository = tableauRepository;
    }
    public List<Tableau> getAllTableaux() {
        return tableauRepository.findAll();
    }

    public Tableau saveTableau(Tableau tableau) {
        return tableauRepository.save(tableau);
    }
    public List<Tableau> getTableauxByCollectionId(Long collectionId) {
        return tableauRepository.findByCollectionId(collectionId);
    }
}
