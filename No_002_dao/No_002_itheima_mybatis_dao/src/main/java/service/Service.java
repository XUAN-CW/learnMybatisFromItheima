package service;

import dao.UserMapper;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author XUAN
 * @date 2020/10/8 - 13:04
 * @references
 * @purpose 演示代理开发方式
 * @errors
 * @note
 *   Mapper 接口开发需要遵循以下四点规范：
 *     - Mapper.xml文件中的namespace与mapper接口的全限定名相同
 *     - Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
 *     - Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql的parameterType的类型相同
 *     - Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
 */
public class Service {

    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        System.out.println(all);

        User user = mapper.findById(1);
        System.out.println(user);

    }
}
