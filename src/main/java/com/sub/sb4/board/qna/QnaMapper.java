package com.sub.sb4.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.sub.sb4.board.BoardMapper;
import com.sub.sb4.board.BoardVO;

@Mapper
public interface QnaMapper extends BoardMapper{
	
	public int setReply(BoardVO boardVO)throws Exception;
	
	public int setRefUpdate(QnaVO qnaVO)throws Exception;

}
