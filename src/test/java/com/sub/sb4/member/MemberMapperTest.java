package com.sub.sb4.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
@Rollback(value=true)
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;

	//@Test
	void setInsertTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testId2");
		memberVO.setPw("testPw2");
		memberVO.setName("testName2");
		memberVO.setAge(25);
		memberVO.setEmail("test2@email.com");
		
		int result = memberMapper.setInsert(memberVO);
		
		assertEquals(1, result);
		
	}
	
	//@Test
	void setInsertFileTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("testId1");
		memberFileVO.setFileName("fileName");
		memberFileVO.setOriName("oriName");
		int result = memberMapper.setInsertFile(memberFileVO);
		
		assertEquals(1, result);
	}
	
	//@Test
	void getMemberLoginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("testId33");
		memberVO.setPw("testPw1");
		
		memberVO = memberMapper.getMemberLogin(memberVO);
		
		assertNotNull(memberVO);
	}

}
