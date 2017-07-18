package jun.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jun.dao.UserDao;
import jun.pojo.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public User findUserById(String sno) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById",sno);
		
		sqlSession.close();
		return user;
	}

	@Override
	public void delete(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUser", id);
		sqlSession.close();
	}

	@Override
	public void insert(User user) throws Exception {
		// TODO Auto-generated method stub

	}

}
