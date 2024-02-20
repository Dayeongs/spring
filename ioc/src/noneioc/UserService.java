package noneioc;

public class UserService {
	
	// UserService는 자신이 사용할 객체(의존하는 객체)를 직접 생성했다. (직접 결정했다.)
	// UserJdbcDao dao = new UserJdbcDao();
	
	// 사용할 객체가 변경되면 수정해야할 부분이 많아진다.
	// 다르게 말하면, 확장성이 떨어진다.
	UserMybatisDao dao = new UserMybatisDao();
	
	public void 회원가입기능() {
		// dao.insert();
		dao.insertUser();
	}
	
	public void 내정보조회기능() {
		// dao.select();
		dao.getUser();
	}
	
}
