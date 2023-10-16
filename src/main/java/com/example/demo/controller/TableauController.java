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


}
