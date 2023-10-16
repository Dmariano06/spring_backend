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
import java.util.Optional;

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

    @PostMapping
    public ResponseEntity<Tableau> createTableau(@RequestBody Tableau tableau) {
        Tableau savedTableau = tableauService.saveTableau(tableau);
        return new ResponseEntity<>(savedTableau, HttpStatus.CREATED);
    }



    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Tableau>> getAllTableaux() {
        List<Tableau> tableaux = tableauService.getAllTableaux();
        return new ResponseEntity<>(tableaux, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTableau(@PathVariable Long id) {
        tableauService.deleteTableau(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tableau> updateTableau(@PathVariable Long id, @RequestBody Tableau updatedTableau) {
        Tableau tableau = tableauService.updateTableau(id, updatedTableau);
        if (tableau != null) {
            return ResponseEntity.ok(tableau);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tableau> getTableauById(@PathVariable Long id) {
        Optional<Tableau> tableau = tableauService.getTableauById(id);
        return tableau.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
