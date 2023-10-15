package com.example.demo.controller;

import com.example.demo.entity.Collection;
import com.example.demo.entity.Tableau;
import com.example.demo.repository.CollectionRepository;
import com.example.demo.repository.TableauRepository;
import com.example.demo.service.CollectionService;
import com.example.demo.service.TableauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("tableau")
public class TableauController {
    @Autowired
    private TableauService tableauService;
    @Autowired
    private CollectionService collectionService;

    public TableauController(TableauService tableauService) {
        this.tableauService = tableauService;
    }


 /*   @CrossOrigin(origins = "*")
    @GetMapping("/tableau/{id}")
    public Tableau getTableauById(@PathVariable Long id) {
        return tableauService.findById(id).orElse(null);
    }*/

    @CrossOrigin(origins = "*")
    @PostMapping("/tableau")
    public ResponseEntity<Tableau> createTableau(@RequestBody Tableau tableau) {
        Tableau createdTableau = tableauService.saveTableau(tableau);
        return new ResponseEntity<>(createdTableau, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/tableau/{id]")
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
    @GetMapping("/byCollection/{collectionId}")
    public ResponseEntity<List<Tableau>> getTableauxByCollection(@PathVariable Long collectionId) {
        List<Tableau> tableaux = tableauService.getTableauxByCollectionId(collectionId);
        return new ResponseEntity<>(tableaux, HttpStatus.OK);
    }
  /*  @CrossOrigin(origins = "*")
    @DeleteMapping("/tableau/{id}")
    public ResponseEntity<Void> deleteTableau(@PathVariable Long id) {
        tableauService.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/
}
