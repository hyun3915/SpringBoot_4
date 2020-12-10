package com.sub.sb4.board.notice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sub.sb4.board.BoardVO;
import com.sub.sb4.board.file.FileVO;
import com.sub.sb4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Value("${board.notice.filePath}")
	private String filePath;
	
	@ModelAttribute(name = "board")
	public String getBoard() {
		return "notice";
	}
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeFileDown")
	public ModelAndView getNoticeFileDown(FileVO fileVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		fileVO = noticeService.getFile(fileVO);
		
		System.out.println(fileVO.getFileName());
		
		mv.addObject("fileVO", fileVO);
		//mv.addObject("filePath", "upload/notice"); 직접 작성
		mv.addObject("filePath", filePath);
		mv.setViewName("fileDown"); //fileDown이라는 뷰를 util에 만들기
		
		return mv;
	}
	
	@GetMapping("noticeList")
	public String getList(Pager pager, Model model) throws Exception{
		
		List<BoardVO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager",pager);
		return "board/boardList";
	}
	
	@GetMapping("noticeWrite")
	public String setInsert(BoardVO boardVO) throws Exception{
		return "board/boardWrite";
	}
	
	@PostMapping("noticeWrite")
	public String setInsert(@Valid BoardVO boardVO, BindingResult bindingResult , MultipartFile [] files) throws Exception{
		System.out.println("--- Notice Write ---");
		if(bindingResult.hasErrors()) {
			System.out.println("--- 검증 실패 ---");
			return "board/boardWrite";
		}
		
		int result = noticeService.setInsert(boardVO, files);
		
		return "redirect:./noticeList";
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardVO boardVO) throws Exception{
		boardVO = noticeService.getOne(boardVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	 @GetMapping("noticeUpdate")
	   public ModelAndView setUpdate2(BoardVO boardVO) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      boardVO = noticeService.getOne(boardVO);
	      mv.addObject("vo",boardVO);
	      mv.setViewName("board/boardUpdate");
	      return mv;
	   }
	   
	   @PostMapping("noticeUpdate")
	   public ModelAndView setUpdate(BoardVO boardVO) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      int result = noticeService.setUpdate(boardVO);
	      
	      String message = "Update Fail";
	      if(result>0) {
	         message = "Update Success";
	      }
	      
	      mv.setViewName("common/result");
	      mv.addObject("msg",message);
	      mv.addObject("path", "./noticeList");
	      
	      return mv;
	   }
	   
	   @GetMapping("noticeDelete")
	   public ModelAndView setDelete(BoardVO boardVO) throws Exception{
	      ModelAndView mv = new ModelAndView();
	      int result = noticeService.setDelete(boardVO);
	      
	      String message = "Delete Fail!";
	      if(result>0) {
	         message = "Delete Success!";
	      }
	      
	      mv.setViewName("common/result");
	      mv.addObject("msg",message);
	      mv.addObject("vo",boardVO);
	      mv.addObject("path", "./noticeList");
	      
	      return mv;
	      
	   }	

}
