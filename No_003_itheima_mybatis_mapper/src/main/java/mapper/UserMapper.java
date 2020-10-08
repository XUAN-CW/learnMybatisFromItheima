package mapper;

import domain.User;

import java.util.List;

/**
 * @author XUAN
 * @date 2020/10/8 - 19:27
 * @references
 * @purpose
 * @errors
 */
public interface UserMapper {

    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);
}
