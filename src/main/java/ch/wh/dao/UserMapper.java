package ch.wh.dao;

import ch.wh.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    public Integer register(User user);

    public User query(String email);

    public Integer update(User user);
}
