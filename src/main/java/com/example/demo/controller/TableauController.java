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
@RequestMapping("/api/tableaux")
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
    @PostMapping("/create")
    public ResponseEntity<Tableau> createTableau(@RequestBody Tableau tableau) {
        try {

            Collection collection = collectionService.getCollectionById(tableau.getCollectionId());
            Tableau createdTableau = tableauService.saveTableau(tableau);
            return new ResponseEntity<>(createdTableau, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public Tableau updateTableau(@PathVariable Long id, @RequestBody Tableau tableau) {
        tableau.setId(id);
        return tableauService.saveTableau(tableau);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Tableau> getAllTableaux() {
        return tableauService.getAllTableaux();
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/byCollection/{collection_id}")
    public ResponseEntity<List<Tableau>> getTableauxByCollection(@PathVariable Long collectionId) {
        List<Tableau> tableaux = tableauService.getTableauxByCollectionId(collectionId);
        return new ResponseEntity<>(tableaux, HttpStatus.OK);
    }

}
