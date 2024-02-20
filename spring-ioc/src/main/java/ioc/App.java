package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// ClassPathXmlApplicationContext가 스프링 컨테이너다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		 
		// getBean() : 객체를 얻는 메소드 (Bean:객체)
		ProductService productService = ctx.getBean(ProductService.class);
		
		productService.신규상품등록();
		productService.상품상세정보조회();
		productService.상품정보수정();
		
	}
	
}