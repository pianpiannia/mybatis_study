package jun.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import jun.pojo.User;
import jun.pojo.UserCustomer;
import jun.pojo.UserQueryVo;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
	
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
	
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
		User user = userMapper.findUserById("100201");
		sqlSession.close();
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
	
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
		List<User> listuser = userMapper.findUserByName("李");
		
		sqlSession.close();
		System.out.println(listuser);
	}
	
	@Test
	//综合查询
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
	
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSsex("女");
		userCustomer.setSname("李");
		
		List<Integer> snos = new ArrayList<Integer>();
		snos.add(100101);
		snos.add(100102);
		userQueryVo.setSnos(snos);
		userQueryVo.setUserCustomer(userCustomer);
		List<UserCustomer> list = userMapper.findUserList(userQueryVo);
		
		sqlSession.close();
		System.out.println(list);
	}
	
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
	
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setSsex("女");
		userCustomer.setSname("李");
		userQueryVo.setUserCustomer(userCustomer);
		int count = userMapper.findUserCount(userQueryVo);
		
		sqlSession.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
	
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	
		
		
		User user = userMapper.findUserByIdResultMap("100201");
		
		sqlSession.close();
		System.out.println(user);
	}
	
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
	
		UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);
		User user1 = userMapper.findUserById("100102");
		System.out.println(user1);
		sqlSession1.close();
		
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = userMapper2.findUserById("100102");
		System.out.println(user2);
		sqlSession2.close();
		
	}

}
