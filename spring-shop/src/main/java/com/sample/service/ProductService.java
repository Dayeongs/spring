package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.ProductMapper;
import com.sample.vo.Company;
import com.sample.vo.Product;
import com.sample.web.dto.Criteria;
import com.sample.web.dto.ListDto;
import com.sample.web.dto.Pagination;
import com.sample.web.form.ProductCreateForm;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private FileService fileService;
	
	/**
	 * ProductCreateForm 객체를 전달받아서 신규 상품으로 등록한다.
	 * @param form 신규 상품정보가 포함된 ProductCreateForm 객체
	 */
	public void createProduct(ProductCreateForm form) {
		
		String filename = fileService.upload(form.getPhotofile());
		
		// Form에서는 int로 companyNo를 담고 Service에서 Company객체를 생성해서 담는다. 
		Company company = Company.builder()
					.no(form.getCompanyNo())
					.build();
		
		// ProductCreateForm 객체에 저장된 값을 Product 객체를 생성하고, 초기화한다.
		// builder 패턴을 사용하여 초기화 / 메소드체이닝 사용
		Product product = Product.builder()
				.name(form.getName())
				.description(form.getDescription())
				.price(form.getPrice())
				.filename(filename)
				.stock(form.getStock())
				.company(company)
				.build();
		
		productMapper.insertProduct(product);
	}
	
	/**
	 * 목록 조회에 필요한 정보를 담고 있는 Criteria 객체를 전달받아서 목록조회한다.<p>
	 * @param criteria 목록조회에 필요한 정보가 들어있는 객체다.
	 * @return 상품목록정보와 페이징처리 정보가 저장된 객체를 반환한다.
	 */
	public ListDto<Product> getProducts(Criteria criteria) {
		// 전체 행의 개수를 조회한다.
		int totalRows = productMapper.getTotalRows(criteria);
		
		// 페이징 처리에 필요한 정보를 표현하는 객체를 생성한다.
		// 현재 페이지번호, 총데이터갯수, 총페이지갯수, 총블록갯수, 현재블록번호, 범위시작번호, 범위끝번호, 페이지시작번호, 페이지끝번호
		Pagination pagination = new Pagination(criteria.getPage(), totalRows, criteria.getRows());
		// 현재 페이지번호에 해당하는 조회범위를 Criteria객체에 저장한다.
		// 검색에 필요한 시작, 종료 범위 값
		criteria.setBegin(pagination.getBegin());
		criteria.setEnd(pagination.getEnd());
		
		// 상품목록을 조회한다.
		// Criteria 객체에는 rows, sort, opt, keyword, begin, end 값이 설정되어 있다.
		List<Product> productList = productMapper.getProducts(criteria);
		
		ListDto<Product> dto = new ListDto<Product>(productList, pagination);
		
		return dto;
	}

	public Product getProductDetail(int no) {
		return productMapper.getProductByNo(no);
	}

	public void deleteProducts(List<Integer> noList) {
		productMapper.deleteProduts(noList);
	}

}
