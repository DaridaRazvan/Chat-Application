package service;

import repository.userRepository;

public class userService {
    public boolean checkUser(String username,String password){
        userRepository userRepository = new userRepository();
        return userRepository.checkUser(username,password);
    }
}
