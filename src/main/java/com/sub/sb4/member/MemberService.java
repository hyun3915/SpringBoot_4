package com.sub.sb4.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getMemberLogin(memberVO);
	}
	
	public int setMemberJoin(MemberVO memberVO, HttpSession session) throws Exception {
	      return memberMapper.setMemberJoin(memberVO);
	   }

}
