package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.ProductMapper;
import com.sample.vo.Product;
import com.sample.web.form.ProductCreateForm;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * ProductCreateForm 객체를 전달받아서 신규 상품으로 등록한다.
	 * @param form 신규 상품정보가 포함된 ProductCreateForm 객체
	 */
	public void createProduct(ProductCreateForm form) {
		// ProductCreateForm 객체에 저장된 값을 Product 객체를 생성하고, 초기화한다.
		// builder 패턴을 사용하여 초기화 / 메소드체이닝 사용
		Product product = Product.builder()
				.name(form.getName())
				.description(form.getDescription())
				.price(form.getPrice())
				.stock(form.getStock())
				.build();
		
		productMapper.insertProduct(product);
	}
	
	public List<Product> getProducts() {
		return productMapper.getAllProducts();
	}

	public Product getProductDetail(int no) {
		return productMapper.getProductByNo(no);
	}

}
