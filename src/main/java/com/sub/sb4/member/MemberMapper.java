package com.sub.sb4.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
	
	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setInsertFile(MemberFileVO memberFileVO) throws Exception;
	
	public int setMemberJoin(MemberVO memberVO) throws Exception;
	
	public MemberVO getMemberId(MemberVO memberVO) throws Exception;
	
}
