/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.services;

import com.example.g8.entities.Clothe;
import com.example.g8.repositories.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClotheService {
    @Autowired
    private ClotheRepository productRepository;

    public List<Clothe> getAll(){
        return productRepository.getAll();
    }

    public Optional<Clothe> getProduct(String id){
        return productRepository.getProduct(id);
    }

    public Clothe save(Clothe product){
        if (product.getReference()== null){
            return product;
        }
        return productRepository.save(product);
    }
   
    public Clothe update(Clothe clotheEdit){
        if(clotheEdit.getReference()!=null){
            Optional<Clothe> resultado = productRepository.getProduct(clotheEdit.getReference());
            if(resultado.isPresent()){
                if(clotheEdit.isAvailability()){
                    resultado.get().setAvailability(clotheEdit.isAvailability());
                }
                if(clotheEdit.getCategory()!=null){
                    resultado.get().setCategory(clotheEdit.getCategory());
                }
                if(clotheEdit.getDescription()!=null){
                    resultado.get().setDescription(clotheEdit.getDescription());
                }
                if(clotheEdit.getPhotography()!=null){
                    resultado.get().setPhotography(clotheEdit.getPhotography());
                }
                if(clotheEdit.getPrice()!= null){
                    resultado.get().setPrice(clotheEdit.getPrice());
                }
                if(clotheEdit.getQuantity()!=null){
                    resultado.get().setQuantity(clotheEdit.getQuantity());
                }
                if(clotheEdit.getSize()!=null){
                    resultado.get().setSize(clotheEdit.getSize());
                }
                productRepository.save(resultado.get());
                return resultado.get();
            }else{
                return clotheEdit;
            }
        }else{
            return clotheEdit;
        }
    }
    
    public boolean delete(String id){
        return getProduct(id).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }

    public List<Clothe> getByPrice(double price){
        return productRepository.getByPrice(price);
    }

    public List<Clothe> getByDescriptionContains(String description){
        return productRepository.getByDescriptionContains(description);
    }
    
}

