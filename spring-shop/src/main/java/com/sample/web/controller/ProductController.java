package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.ProductService;
import com.sample.vo.Product;
import com.sample.web.form.ProductCreateForm;

/*
 * @Controller
 *		이 클래스가 MVC 패턴에서 컨트롤러의 역할을 수행하는 클래스임을 나타낸다.
 *		이 클래스가 컴포넌트스캔 대상 클래스임을 나타낸다. 
 *		컴포넌트 스캔 대상 클래스는 애플리케이션 시작시에 스프링 컨테이너가 객체를 생성하고, 필요한 의존성을 주입한다.
 *
 * @RequestMapping
 * 		URL 매핑정보를 정의한다.
 * 		클래스에 정의된 URL 매핑정보는 요청핸들러 메소드에 정의된 URL 매핑정보와 접두사처럼 추가된다.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	
	/*
	 * @Autowired
	 * 		자동의존성 주입을 지원하는 어노테이션이다.
	 * 		ProductController가 의존하는 객체를 스프링 컨테이너에서 찾아서 자동으로 조립한다.
	 * 		만약 ProductService 타입의 객체가 스프링 컨테이너에 없으면, 애플리케이션 시작시 오류가 발생한다.
	 */
	@Autowired
	private ProductService productService;
	
	/*
	 * 요청URL 
	 * 		/product/detail?no=10
	 * 요청파라미터
	 * 		no=10
	 */
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Product product = productService.getProductDetail(no);
		model.addAttribute("product", product);
		
		return "product/detail";
		// "/WEB-INF/views/product/detail.jsp"로 내부이동
	}
	
	@GetMapping(path = "/list")
	public String list(Model model) {
		List<Product> productList = productService.getProducts();
		model.addAttribute("productList", productList);
		
		return "product/list";		// "/WEB-INF/views/product/list.jsp"로 내부이동
	}
	
	@GetMapping(path = "/create")
	public String form() {
		
		return "product/form";		// "/WEB-INF/views/product/form.jsp"로 내부이동
	}
	@PostMapping(path = "/create")
	public String create(ProductCreateForm productCreateForm) {
		productService.createProduct(productCreateForm);
		
		return "redirect:list";
	}
	// ProductCreateForm productCreateForm
	// 1. ProductCreateForm 객체 생성
	// 2. Form 객체의 멤버변수 분석 (price, name, stock, description)
	// 3. 멤버변수명과 동일한 이름의 요청파라미터값을 조회한다.
	// 4. 매개변수에 전달한다.
}
