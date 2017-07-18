package jun.mapper;

import java.util.List;

import jun.pojo.User;
import jun.pojo.UserCustomer;
import jun.pojo.UserQueryVo;

public interface UserMapper {

	public User findUserByIdResultMap(String sno)throws Exception;
	
	public int findUserCount(UserQueryVo userQueryVo)throws Exception;
	
	public List<UserCustomer> findUserList(UserQueryVo userQueryVo)throws Exception;
	
	public User findUserById(String sno) throws Exception;

	public void deleteUser(int sno)throws Exception;
	
	public void insertUser(User user)throws Exception;
	
	public List<User> findUserByName(String sname)throws Exception;


}