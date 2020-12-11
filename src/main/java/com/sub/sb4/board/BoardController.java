package com.sub.sb4.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sub.sb4.board.notice.NoticeService;
import com.sub.sb4.util.Pager;

@RestController
@RequestMapping("/board/**")
public class BoardController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("boardSelect")
	public BoardVO boardSelect(BoardVO boardVO) throws Exception{
		System.out.println("Board Select Controller");
		boardVO = noticeService.getOne(boardVO);
//		System.out.println("title : "+boardVO.getTitle());
		//{"키":"벨류", "키":"벨류"}
//		String result = "{";
//		result = result +"\"num\":"+boardVO.getNum()+",";
//		result = result+"\"title\":\""+boardVO.getTitle()+"\"}";
//		System.out.println(result);
		
		return boardVO;
	}
	
	@GetMapping("board/boardList")
	public List<BoardVO> boardList(Pager pager) throws Exception{
		System.out.println("Board List Controller");
		List<BoardVO> ar = noticeService.getList(pager);
		return ar;
	}

}
