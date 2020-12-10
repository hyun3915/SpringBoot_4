package com.sub.sb4.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sub.sb4.board.BoardVO;
import com.sub.sb4.board.file.FileVO;
import com.sub.sb4.util.Pager;


@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@GetMapping("qnaList")
	public String getList(Pager pager, Model model) throws Exception{
		List<BoardVO> ar = qnaService.getList(pager);
		
		model.addAttribute("board", "qna");
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/boardList";
	}
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert(BoardVO boardVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "qna");
		return mv;
	}

	@PostMapping("qnaWrite")
	public String setInsert(@Valid BoardVO boardVO, BindingResult bindingResult,MultipartFile[] files)throws Exception{
		
		System.out.println("--- QnA Write ---");
		
		if(bindingResult.hasErrors()) {
			System.out.println("--- 검증실패 ---");
			return "board/boardWrite";
		}
		
		int result = qnaService.setInsert(boardVO,files);
		
		ModelAndView mv = new ModelAndView();
		
		 String message = "Write Fail";
	      if(result>0) {
	         message = "Write Success";
	      }
	      
		
		mv.setViewName("common/result");
		mv.addObject("msg",message);
		mv.addObject("path", "./qnaList");
		
		
		return "redurect:./qnaList";
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = qnaService.getOne(boardVO);
			mv.setViewName("board/boardSelect");
			mv.addObject("board", "qna");
			mv.addObject("vo", boardVO);
		
		return mv;
	}
	
	   @GetMapping("qnaUpdate")
	   public ModelAndView setUpdate2(BoardVO boardVO) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      boardVO = qnaService.getOne(boardVO);
	      mv.addObject("board", "qna");
	      mv.addObject("vo",boardVO);
	      mv.setViewName("board/boardUpdate");
	      return mv;
	   }
	   
	   @PostMapping("qnaUpdate")
	   public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      int result = qnaService.setUpdate(boardVO);
	      
	      String message = "Update Fail";
	      if(result>0) {
	         message = "Update Success";
	      }
	      
	      mv.setViewName("common/result");
	      mv.addObject("msg",message);
	      mv.addObject("path", "./qnaList");
	      
	      return mv;
	   }
	   
	   @GetMapping("qnaDelete")
	   public ModelAndView setDelete(BoardVO boardVO) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      int result = qnaService.setDelete(boardVO);
	      
	      String message = "Delete Fail!";
	      if(result>0) {
	         message = "Delete Success!";
	      }
	      
	      mv.setViewName("common/result");
	      mv.addObject("msg",message);
	      mv.addObject("vo",boardVO);
	      mv.addObject("path", "./qnaList");
	      
	      return mv;
	   }
	   
	   @PostMapping("qnaReply")
		public ModelAndView setReply(BoardVO boardVO)throws Exception{
			ModelAndView mv = new ModelAndView();
			int result = qnaService.setReply(boardVO);
			
			String message = "Reply Write Fail";
			
			if(result>0) {
				message = "Reply Write Success";
			}
			
			mv.setViewName("common/result");
			mv.addObject("msg", message);
			mv.addObject("vo",boardVO);
			mv.addObject("path", "./qnaList");
			
			return mv;
		}
		
		@GetMapping("qnaReply")
		public ModelAndView setReply()throws Exception{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("board/boardReply");
			mv.addObject("board", "qna");
			return mv;
		}
	
		@GetMapping("qnaFileDown")
		public ModelAndView getNoticeFileDown(FileVO fileVO)throws Exception{
			ModelAndView mv = new ModelAndView();
			fileVO = qnaService.getFile(fileVO);
			
			mv.addObject("fileVO", fileVO);
			mv.addObject("filePath", filePath);
			mv.setViewName("fileDown");
			
			return mv;
		}
	
}
