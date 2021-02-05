package ch.wh.service.impl;

import ch.wh.dao.UserMapper;
import ch.wh.pojo.User;
import ch.wh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static ch.wh.util.Util.md5;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {java.lang.Exception.class})
    public User register(String firstName, String lastName, String email, String password) {
        logger.info("try register by {}...", email);
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        String md5Password = md5(password);
        user.setPassword(md5Password);

        userMapper.register(user);

        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User signin(String email, String password) {
        String md5Password = md5(password);

        User user = userMapper.query(email);
        if(user.getPassword().equals(md5Password)) {
            return user;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {java.lang.Exception.class})
    public Integer changePassword(String email, String password) {
        String md5Password = md5(password);

        User user = new User();
        user.setEmail(email);
        user.setPassword(md5Password);

        Integer ret = userMapper.update(user);
        if(ret == 0) {
            throw new RuntimeException();
        }
        return ret;
    }
}
