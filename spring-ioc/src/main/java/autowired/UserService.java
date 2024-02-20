package autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao; // 객체가 조립될 멤버변수
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void 회원가입() {
		userDao.getUser();
		userDao.inserUser();
	}

}
