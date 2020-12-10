package com.sub.sb4.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberLogin")
	public void getMemberLogin() throws Exception{
		
	}
	
	@PostMapping("memberLogin")
	public ModelAndView getMemberLogin(MemberVO memberVO, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getMemberLogin(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
			
		}else {
			String message = "Login Fail";
			mv.addObject("msg", message);
			mv.addObject("path", "./memberLogin");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@GetMapping("memberLogout")
	public String getMemberLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("memberPage")
	public void getMemberPage() throws Exception{
		//따로 보낼게 없음! session으로 할거라서
	}
	
	@GetMapping("memberJoin") 
	public ModelAndView setMemberJoin(MemberVO memberVO)throws Exception{ 
 		ModelAndView mv = new ModelAndView(); 
 		mv.setViewName("member/memberJoin"); 
		return mv; 
	 	} 
		 
	@PostMapping("memberJoin") 
	public ModelAndView setMemberJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile multipartFile)throws Exception{ 
		ModelAndView mv = new ModelAndView();
	 	
		System.out.println("--- Join ---");
		if(memberService.getMemberError(memberVO, bindingResult)) {
			mv.setViewName("member/memberJoin");
			return mv;
		}
		
		//검증이 통과일 때 실행하는 코드
		mv.setViewName("redirect:../");
		 
		return mv; 
	} 

}
