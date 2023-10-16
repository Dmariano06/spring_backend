package com.example.demo.controller;

import com.example.demo.entity.Collection;
import com.example.demo.entity.Tableau;
import com.example.demo.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public Collection addCollection(@RequestBody Collection collection) {
        return collectionService.saveCollection(collection);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Collection> getAllCollections() {
        return collectionService.getAllCollections();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Collection getCollectionById(@PathVariable Long id) {
        return collectionService.getCollectionById(id);
    }

    @PostMapping("/{collectionId}/tableaux")
    public ResponseEntity<Tableau> addTableauToCollection(
            @PathVariable Long collectionId,
            @RequestBody Tableau tableau) {
        Tableau savedTableau = collectionService.addTableauToCollection(collectionId, tableau);
        return new ResponseEntity<>(savedTableau, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Collection> updateCollection(
            @PathVariable Long id,
            @RequestBody Collection updatedCollection) {
        Collection updated = collectionService.updateCollection(id, updatedCollection);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable Long id) {
        collectionService.deleteCollection(id);
        return ResponseEntity.noContent().build();
    }
}
