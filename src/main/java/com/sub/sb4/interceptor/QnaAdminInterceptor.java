package com.sub.sb4.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sub.sb4.board.BoardVO;
import com.sub.sb4.board.qna.QnaMapper;
import com.sub.sb4.member.MemberRoleVO;
import com.sub.sb4.member.MemberVO;

@Component
public class QnaAdminInterceptor implements HandlerInterceptor{

	@Autowired
	private CustomInterceptor customInterceptor;
	
	@Autowired
	private QnaMapper qnaMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		
		boolean result = false;
		
		System.out.println(request.getRequestURI());
		String path = request.getRequestURI();
		String kind = path.substring(path.lastIndexOf("qna")).replace("qna", "");
		
		String message = "권한이 필요합니다.";
		
		if(memberVO != null) {
			List<MemberRoleVO> roles = memberVO.getRoles();
			for(MemberRoleVO memberRoleVO:roles) {
				if(memberRoleVO.getRole().equals("admin")) {
					if(kind.equals("Write")) {
						result = true;
						break;
					} else {
						int num = Integer.parseInt(request.getParameter("num"));
						BoardVO boardVO = new BoardVO();
						boardVO.setNum(num);
						boardVO = qnaMapper.getOne(boardVO);
						
						if(boardVO.getWriter().equals(memberVO.getId())) {
							result =true;
							break;
						}else {
							message = "작성자만 접근이 가능합니다.";
						}
					}
				}
			}
		}
		
		if(!result) {
			request.setAttribute("msg", message);
			request.setAttribute("path", "../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return result;
	}
	
	
	
}
