package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.UserRole;

@Mapper
public interface UserRoleMapper {
	
	void insertUserRole(UserRole userRole); // 추가
	void deleteUserRole(UserRole userRole); // 삭제
	List<UserRole> getUserRolesByUserNo(int userNo); // 조회

}
