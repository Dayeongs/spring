package com.example.vo;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter
@Service
@ToString
public class Company {

	private int no;
	private String name;
	private String tel;
	private String zipcode;
	private String address1;
	private String address2;
	
	
}
