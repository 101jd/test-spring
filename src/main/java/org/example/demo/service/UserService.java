package org.example.demo.service;

import org.example.demo.model.User;
import org.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<User> findAll(){
        return repo.findAll();
    }

    public User save(User user){
        return repo.save(user);
    }


    //HOMEWORK:

    public void delete(int id){
        repo.delete(id);
    }

    public void update(String fName, String lName, User user){
        repo.update(user, fName, lName);
    }
}
