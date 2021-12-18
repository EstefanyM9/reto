/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.controller;

import com.example.g8.entities.Clothe;
import com.example.g8.services.ClotheService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clothe")
@CrossOrigin(origins = "*")
public class ClothesController {
    
    @Autowired
    private ClotheService productService;

    @GetMapping("/all")
    public List<Clothe> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clothe> getProduct(@PathVariable("id") String id){
        return productService.getProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Clothe product){
        productService.save(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id){
        return productService.delete(id);
    }

    @GetMapping("/price/{price}")
    public List<Clothe> getByPrice(@PathVariable("price") double price){
        return productService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Clothe> getByDescriptionContains(@PathVariable("description") String description){
        return productService.getByDescriptionContains(description);
    }
    
  
}

