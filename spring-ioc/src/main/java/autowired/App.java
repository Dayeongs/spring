package autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context-autowired.xml");
		
		// 해당 타입이 하나밖에 없다고 가정
		UserDao userDao = ctx.getBean(UserDao.class);
		UserService userService = ctx.getBean(UserService.class);
		
		System.out.println(userDao);
		System.out.println(userService);
		
		userService.회원가입();
	}

}
