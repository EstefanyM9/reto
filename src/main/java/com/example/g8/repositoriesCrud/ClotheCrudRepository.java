/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.repositoriesCrud;

import com.example.g8.entities.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClotheCrudRepository extends MongoRepository<Clothe,Integer>{
    
        Optional<Clothe> findByReference(String reference);
        public List<Clothe> findByPrice(Double price);
        public List<Clothe> findByDescriptionContainingIgnoreCase(String description);
    
        
}
