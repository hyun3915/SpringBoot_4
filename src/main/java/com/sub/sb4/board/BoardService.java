package com.sub.sb4.board;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sub.sb4.board.file.FileVO;
import com.sub.sb4.util.Pager;

@Service
public interface BoardService {
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception;
	
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public FileVO getFile(FileVO fileVO) throws Exception;

}
