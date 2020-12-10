package com.sub.sb4;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlSessionTest {
	
	@Autowired
	private SqlSession sqlSession;

	@Test
	void test() {
		assertNotNull(sqlSession.getConnection());
	}

}
