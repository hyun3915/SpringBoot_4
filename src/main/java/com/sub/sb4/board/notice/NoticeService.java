package com.sub.sb4.board.notice;

import java.io.File;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sub.sb4.board.BoardService;
import com.sub.sb4.board.BoardVO;
import com.sub.sb4.board.file.FileVO;
import com.sub.sb4.util.FileManager;
import com.sub.sb4.util.FilePathGenerator;
import com.sub.sb4.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${board.notice.filePath}")
	private String filePath;

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		
		int result = noticeMapper.setInsert(boardVO);
		System.out.println("Num : "+boardVO.getNum());
		
		//1. HDD에 File 저장
		//-- 저장할 폴더의 실제 경로명 필요
		File file = filePathGenerator.getUseResourceLoader(this.filePath);
		
		System.out.println(file.getAbsolutePath());
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.getSize()==0) {
				continue;
			}
			String fileName = fileManager.saveFileCopy(multipartFile, file);
			System.out.println(fileName);
			
			FileVO fileVO = new FileVO();
			fileVO.setFileName(fileName);
			fileVO.setOriName(multipartFile.getOriginalFilename());
			fileVO.setNum(boardVO.getNum());
			//fileVO.setNum(2000);
			
			result = noticeMapper.setInsertFile(fileVO);
			
		}
		return result;
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getOne(boardVO);
	}

	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		long totalCount = noticeMapper.getCount(pager);
		pager.makePage(totalCount);
		
		return noticeMapper.getList(pager);
	}

	@Override
	public FileVO getFile(FileVO fileVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getFile(fileVO);
	}
	

}
