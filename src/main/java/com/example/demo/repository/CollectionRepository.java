package com.example.demo.repository;
import com.example.demo.entity.Collection;
import com.example.demo.entity.Tableau;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@EnableJpaRepositories
@Repository

public interface CollectionRepository extends JpaRepository<Collection, Long>{
}
