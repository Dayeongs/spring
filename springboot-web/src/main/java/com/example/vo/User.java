package com.example.vo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

	private String id;
	private String password;
	private String name;
	private String tel;
	private String email;
	private Date createdDate;
	private Date updatedDate;
	
	@Builder
	public User(String id, String password, String name) {
		
	}
	

/* Builder 패턴 사용
 *	public User(String id, String password) {
 *		this.id = id;
 *		this.password = password;
 *	}
 *	
 *	// User.builder()를 호출하면 UserBuilder객체가 얻어진다.
 *	public static UserBuilder builder() {
 *		return new UserBuilder();
 *	}
 *	
 *	// 내부클래스
 *	public static class UserBuilder {
 *		private String id;
 *		private String password;
 *		
 *		public UserBuilder id(String id) {
 *			this.id = id;
 *			return this;
 *		}
 *		public UserBuilder password(String password) {
 *			this.password = password;
 *			return this;
 *		}
 *		public User build() {
 *			User user = new User(id, password);
 *   			return user;
 *   		}
 *  	}
 * 
 */

}
