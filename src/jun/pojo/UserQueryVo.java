package jun.pojo;

import java.util.List;

public class UserQueryVo {

	//private User user;
	private List<Integer> snos;
	
	private UserCustomer userCustomer;

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public List<Integer> getSnos() {
		return snos;
	}

	public void setSnos(List<Integer> snos) {
		this.snos = snos;
	}
}
