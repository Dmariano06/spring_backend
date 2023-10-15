package com.example.demo.service;

import com.example.demo.entity.Tableau;
import com.example.demo.repository.TableauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableauService {
    @Autowired
    private TableauRepository tableauRepository;

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
