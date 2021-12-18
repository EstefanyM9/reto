/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.repositories;

import com.example.g8.entities.Clothe;
import com.example.g8.repositoriesCrud.ClotheCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClotheRepository{
    
    @Autowired
    private ClotheCrudRepository productCrudRepository;

    public List<Clothe> getAll(){
        return productCrudRepository.findAll();
    }

    public Optional<Clothe> getProduct(String id){
        return productCrudRepository.findByReference(id);
    }

    public Clothe save(Clothe product){
        return productCrudRepository.save(product);
    }

    public void update(Clothe product){
        productCrudRepository.save(product);
    }

    public void delete(Clothe product){
        productCrudRepository.delete(product);
    }

    public List<Clothe> getByPrice(double price){
        return productCrudRepository.findByPrice(price);
    }

    public List<Clothe> getByDescriptionContains(String description){
        return productCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }
    
}
