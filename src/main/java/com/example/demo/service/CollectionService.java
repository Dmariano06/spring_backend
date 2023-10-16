package com.example.demo.service;
import com.example.demo.entity.Collection;
import com.example.demo.entity.Tableau;
import com.example.demo.repository.CollectionRepository;
import com.example.demo.repository.TableauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    public Collection saveCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection getCollectionById(Long id) {
        return collectionRepository.findById(id).orElse(null);
    }
    @Autowired
    private TableauRepository tableauRepository;

    public Tableau addTableauToCollection(Long collectionId, Tableau tableau) {
        Collection collection = collectionRepository.findById(collectionId)
                .orElseThrow(() -> new EntityNotFoundException("Collection not found with id: " + collectionId));

        tableau.setCollection(collection);
        Tableau savedTableau = tableauRepository.save(tableau);

        // Mettre à jour la liste de tableaux dans la collection
        collection.getTableaux().add(savedTableau);
        collectionRepository.save(collection);

        return savedTableau;
    }
    public Collection updateCollection(Long id, Collection updatedCollection) {
        Optional<Collection> optionalCollection = collectionRepository.findById(id);

        if (optionalCollection.isPresent()) {
            Collection existingCollection = optionalCollection.get();
            // Mettez à jour les propriétés nécessaires de la collection existante avec les valeurs de la collection mise à jour
            existingCollection.setNom(updatedCollection.getNom());
            // ... Autres propriétés ...

            return collectionRepository.save(existingCollection);
        } else {
            return null;
        }
    }

    public void deleteCollection(Long id) {
        if (collectionRepository.existsById(id)) {
            collectionRepository.deleteById(id);
        } else {
         return;
        }
    }
}
