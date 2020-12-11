package com.sub.sb4.schedule;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sub.sb4.board.BoardVO;
import com.sub.sb4.board.notice.NoticeMapper;
import com.sub.sb4.util.Pager;

@Component
public class CustomSchedule {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	//@Scheduled(fixedRate = 1000, initialDelay = 2000)
	//@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void fixRateTest() throws Exception{
		System.out.println(Thread.currentThread().getName());		
		System.out.println("----- Fix Rate Test -----");
		
	}
	
	//@Scheduled(fixedDelay = 1000, initialDelay = 2000)
	public void fixedDelayTest() throws Exception{
		System.out.println(Thread.currentThread().getName());
		System.out.println("----- Fixed Delay Test -----");
		
	}
	
	//@Scheduled(cron = "* * * * * *")
	public void cronTest() throws Exception{
		Calendar ca = Calendar.getInstance();
		System.out.println("----- cron Test -----");
		System.out.println(ca.getTime());
		System.out.println(Thread.currentThread().getName());
		
		Pager pager = new Pager();
		pager.setCurPage(1);
//		pager.makeRow();
//		
//		List<BoardVO> ar =  noticeMapper.getList(pager);
//		
//		for(BoardVO boardVO: ar) {
//			System.out.println(boardVO.getTitle());
//		}
	}

}
