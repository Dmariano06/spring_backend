package com.example.demo.controller;

import com.example.demo.entity.Collection;
import com.example.demo.entity.Tableau;
import com.example.demo.repository.CollectionRepository;
import com.example.demo.repository.TableauRepository;
import com.example.demo.service.CollectionService;
import com.example.demo.service.TableauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TableauController {
    @Autowired
    private TableauService tableauService;
    @Autowired
    private CollectionService collectionService;

 /*   @CrossOrigin(origins = "*")
    @GetMapping("/tableau/{id}")
    public Tableau getTableauById(@PathVariable Long id) {
        return tableauService.findById(id).orElse(null);
    }*/

    @CrossOrigin(origins = "*")
    @PostMapping("/tableau")
    public Tableau createTableau(@RequestBody Tableau tableau) {
        return tableauService.saveTableau(tableau);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/tableau")
    public Tableau updateTableau(@PathVariable Long id, @RequestBody Tableau tableau) {
        tableau.setId(id);
        return tableauService.saveTableau(tableau);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tableau")
    public List<Tableau> getAllTableaux() {
        return tableauService.getAllTableaux();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/collections")
    public Collection createCollection(@RequestBody Collection collection) {
        return collectionService.saveCollection(collection);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/collections")
    public List<Collection> getAllCollections() {
        return collectionService.getAllCollections();
    }
  /*  @CrossOrigin(origins = "*")
    @DeleteMapping("/tableau/{id}")
    public ResponseEntity<Void> deleteTableau(@PathVariable Long id) {
        tableauService.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/
}
