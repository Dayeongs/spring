package com.example.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 1. 데이터베이스에 저장되어 있는 사용자 정보 조회
		User user = userMapper.getUserById(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		// 2. UserDetails인터페이스의 구현객체인 UserDetailsImpl에 사용자 정보를 저장하고 반환한다.
		return new UserDetailsImpl(user.getId(), user.getPassword(), user.getName(), List.of(new SimpleGrantedAuthority("ROLE_USER")));

	}

}
