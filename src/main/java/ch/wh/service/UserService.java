package ch.wh.service;

import ch.wh.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User register(String firstName, String lastName, String email, String password);

    public User signin(String email, String password);

    public Integer changePassword(String email, String password);
}
