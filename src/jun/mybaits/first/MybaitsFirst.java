package jun.mybaits.first;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import jun.pojo.User;

/**
 * 
 * @author jun
 *
 */
public class MybaitsFirst {

	@Test
	public void findUserByName1() throws IOException{
		
		//配置文件
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById", "100101");
		
		System.out.println(user);
		
		sqlSession.close();
	}

	@Test
	public void findUserByName() throws IOException{
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list =  sqlSession.selectList("test.findUserByName", "李");
		System.out.println(list);
		sqlSession.close();
	}

	@Test
	public void insertUser() throws IOException{
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		//user.setSno(100301);
		user.setSname("xiaohong");
		user.setSage(18);
		user.setSsex("男");
		user.setSdept("电子技术");
		
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		System.out.println(user.getSno());
		sqlSession.close();
	}
	
	@Test
	public void deleteUser() throws IOException{
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUser", 100303);
		
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void updateUser() throws IOException{
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		
		user.setSname("heiehi");
		user.setSage(19);
		user.setSsex("男");
		user.setSdept("电子技术");
		user.setSno(100304);	
		sqlSession.update("test.updateUser", user);
		//sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
}
