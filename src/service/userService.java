package service;

import domain.User;
import repository.userRepository;

public class userService {
    private repository.userRepository userRepository = new userRepository();

    public boolean addUser(String username, String password, String firstName, String lastName){
        userRepository.addUser(username,password,firstName,lastName);
        return true;
    }

    public boolean checkUser(String username,String password){
        return userRepository.checkUser(username,password);
    }
}
