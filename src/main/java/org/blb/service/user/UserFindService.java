package org.blb.service.user;

import org.blb.exeption.AlreadyExistException;
import org.blb.exeption.NotFoundException;
import org.blb.exeption.RestException;
import org.blb.models.user.User;
import org.blb.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public User getUserFromContext(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findUserByEmail(email)
                .orElseThrow(()->new AccessDeniedException("Access denied"));
    }
    public User findUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(()
                        -> new NotFoundException( "User not found"));
    }
    public void findUserForAuth(String Email) {
        if(repository.findUserByEmail(Email).isPresent()){
            throw new AlreadyExistException( "User with Email : " + Email + " has already registered");
        }
    }
}
