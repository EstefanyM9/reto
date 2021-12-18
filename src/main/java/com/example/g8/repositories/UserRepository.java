/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.repositories;

import com.example.g8.entities.User;
import com.example.g8.repositoriesCrud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
    
    @Autowired
    /**
     * Dependencies Injection
     */
    private UserCrudRepository userCrudRepository;

    /**
     * This method returns a list of all the users
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * This method returns a user by its id
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * This method saves a user
     * @param user
     * @return
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    /**
     * This method updates a user
     * @param user
     */
    public void update(User user){
        userCrudRepository.save(user);
    }

    /**
     * This method deletes a user
     * @param user
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }

    /**
     * This method verifies if the email is registered in the database
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    /**
     * This method authenticates a user by its email and password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * This method returns a user by its monthBirthDay
     * @param month
     * @return
     */
   /* public List<User> getByMonthBirthDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }*/      
}
