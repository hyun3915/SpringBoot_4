package com.sub.sb4.board;

import java.util.List;

import com.sub.sb4.board.file.FileVO;
import com.sub.sb4.util.Pager;

public interface BoardMapper {
	
	public long getCount(Pager pager) throws Exception;
	
	public List<BoardVO> getList(Pager pager) throws Exception;
	
	public int setInsert(BoardVO boardVO) throws Exception;
	
	public int setInsertFile(FileVO fileVO) throws Exception;
	
	//title, contents, update
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardVO getOne(BoardVO boardVO) throws Exception;
	
	public FileVO getFile(FileVO fileVO) throws Exception;

}
