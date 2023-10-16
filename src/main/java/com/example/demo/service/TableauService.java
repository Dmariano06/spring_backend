package com.example.demo.service;

import com.example.demo.entity.Collection;
import com.example.demo.entity.Tableau;
import com.example.demo.repository.CollectionRepository;
import com.example.demo.repository.TableauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableauService {
    @Autowired
    private TableauRepository tableauRepository;

    private CollectionService collectionService;
    public Optional<Tableau> findById(Long id) {
        return tableauRepository.findById(id);
    }

    public void deleteById(Long id) {
        tableauRepository.deleteById(id);
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
    public void deleteTableau(Long id) {
        tableauRepository.deleteById(id);
    }

    public Tableau updateTableau(Long id, Tableau updatedTableau) {
        if (tableauRepository.existsById(id)) {
            updatedTableau.setId(id);
            return tableauRepository.save(updatedTableau);
        }
        return null;
    }
    public Optional<Tableau> getTableauById(Long id) {
        return tableauRepository.findById(id);
    }
}
