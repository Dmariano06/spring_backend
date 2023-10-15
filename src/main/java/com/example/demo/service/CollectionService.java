package com.example.demo.service;
import com.example.demo.entity.Collection;
import com.example.demo.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection saveCollection(Collection collection) {
        return collectionRepository.save(collection);
    }
}
