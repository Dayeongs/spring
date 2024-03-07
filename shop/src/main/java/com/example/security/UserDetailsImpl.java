package com.example.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//인증에 필요한 사용자 정보를 제공(표현)하는 클래스
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 6793590474713548621L;
	
	private String username;
	private String password;
	private String name;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl(String username, String password, String name, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.authorities = authorities;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() { // 비밀번호 반환
		return password;
	}

	@Override
	public String getUsername() { // 아이디 반환
		return username;
	}

	@Override
	public boolean isAccountNonExpired() { // 계정만료 여부
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정잠김 여부
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 비밀번호만료 여부
		return true;
	}

	@Override
	public boolean isEnabled() { // 활성화 여부
		return true;
	}

}
