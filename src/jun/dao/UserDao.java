package jun.dao;

import jun.pojo.User;

public interface UserDao {

	public User findUserById(String id) throws Exception;
	
	public void delete(int id) throws Exception;
	
	public void insert(User user) throws Exception;


}
