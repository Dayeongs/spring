package com.sample.web.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductCreateForm {
	
	private String name;
	private int price;
	private int stock;
	// MultipartFile : Spring에서 첨부파일 업로드를 지원하는 객체
	private MultipartFile photofile;
	private String description;

}
