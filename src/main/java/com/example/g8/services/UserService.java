/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.services;

import com.example.g8.entities.User;
import com.example.g8.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
     @Autowired
    private UserRepository userRepository;

    /**
     * Get = List of All Users
     * @return
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Get = User by its id
     * @param id
     * @return
     */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    /**
     * This method saves a new user
     * @param user
     * @return
     */
    public User save(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (dbUser.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return userRepository.save(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
        }

    /**
     * This method updates a user
     * @param user
     * @return
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> dbUser = userRepository.getUser(user.getId());
            if (!dbUser.isEmpty()) {
                if (user.getIdentification() != null) {
                    dbUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    dbUser.get().setName(user.getName());
                }

                /*if (user.getBirthtDay() != null){
                    dbUser.get().setBirthtDay(user.getBirthtDay());
                }

                if (user.getMonthBirthtDay() != null){
                    dbUser.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }*/
                if (user.getAddress() != null) {
                    dbUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    dbUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    dbUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    dbUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    dbUser.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    dbUser.get().setType(user.getType());
                }
                userRepository.update(dbUser.get());
                return dbUser.get();
            } else {
                return user;
            }
        }
        return user;
    }

    /**
     * This method checks if an email exists
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     * This method deletes a User
     * @param userId
     * @return
     */
    public boolean delete(int userId) {
        Boolean userBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return userBoolean;
    }

    /**
     * This method verifies if a user is registered by its email and password
     * @param email
     * @param password
     * @return
     */

    public User authenticateUser(String email, String password){
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (!usuario.isPresent()) {
            return new User();
        } else {
            return usuario.get();
        }
    
    }
    /*public List<User> getByMonthBirthDay(String month){
        return userRepository.getByMonthBirthDay(month);
    }*/
}
