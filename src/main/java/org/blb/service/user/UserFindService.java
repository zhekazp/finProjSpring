package org.blb.service.user;

import org.blb.exeption.RestException;
import org.blb.models.user.User;
import org.blb.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFindService {
    UserRepository repository;

    public UserFindService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }


    public User findUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(()
                        -> new RestException(HttpStatus.NOT_FOUND, "User not found"));
    }
    public void findUserByEmail(String Email) {
        if(repository.findUserByEmail(Email).isPresent()){
            throw new RestException(HttpStatus.CONFLICT, "User with Email : " + Email + " has already registered");
        }
    }
}
