package com.sub.sb4.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		return memberMapper.getMemberLogin(memberVO);
	}
	
	//검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		//result : true -> 검증위반(실패)
		//result : false -> 검증성공
		boolean result = false;
		
		//기본 annotation 검증 결과
		if(bindingResult.hasErrors()) {
			result = true;
		}
		
		//password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPw2())) {
			//bindingResult.rejectValue("멤버변수명", "properties 파일의 코드(키)", "코드기 없으면 기본메세지");
			bindingResult.rejectValue("pw2", "memberVO.password.notEqaul");
			result = true;
		}
		
		
		//id중복검사 검증
		MemberVO mv = memberMapper.getMemberId(memberVO);
		if(mv != null) {
			bindingResult.rejectValue("id", "memberVO.id.eqaul");
			result = true;
		}
		
		return result;
	}
	
	public int setMemberJoin(MemberVO memberVO, HttpSession session) throws Exception {
	      return memberMapper.setMemberJoin(memberVO);
	   }

}
