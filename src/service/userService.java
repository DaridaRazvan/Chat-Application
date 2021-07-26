package service;

import domain.User;
import repository.userRepository;

public class userService {
    private userRepository userRepository = new userRepository();

    public boolean addUser(String username, String password, String firstName, String lastName){
        User user = new User(username,password,firstName,lastName);
        userRepository.addUser(user);
        return true;
    }

    public boolean checkUser(String username,String password){
        return userRepository.checkUser(username,password);
    }
}
