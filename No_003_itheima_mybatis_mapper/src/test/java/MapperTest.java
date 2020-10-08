import domain.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XUAN
 * @date 2020/10/8 - 19:34
 * @references
 * @purpose
 * @errors
 */
public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        //选择其中几个条件，可见查询语句的不同
        User condition = new User();
        condition.setId(1);
//        condition.setUsername("zhangsan");
        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);

        //模拟ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        List<User> userList2 = mapper.findByIds(ids);
        System.out.println(userList2);
    }
}
