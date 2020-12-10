package com.sub.sb4.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PagerTest {

	@Test
	void PagerTest() {
		Pager pager = new Pager();
		pager.setCurPage(11);
		pager.makePage(102);
	}

}
