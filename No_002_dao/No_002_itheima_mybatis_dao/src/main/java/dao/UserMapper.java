package dao;

import domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author XUAN
 * @date 2020/10/8 - 13:02
 * @references
 * @purpose
 * @errors
 */
public interface UserMapper {

    public List<User> findAll() throws IOException;

    public User findById(int id);

}

