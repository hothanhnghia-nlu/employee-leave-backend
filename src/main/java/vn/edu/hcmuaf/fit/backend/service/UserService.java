package vn.edu.hcmuaf.fit.backend.service;

import vn.edu.hcmuaf.fit.backend.model.User;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUserByID(int id);
    User updateUserByID(User user, int id);
    void deleteUserByID(int id);
}
