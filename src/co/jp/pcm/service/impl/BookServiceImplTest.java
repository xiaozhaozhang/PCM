package co.jp.pcm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.pcm.Test.BaseTest;
import co.jp.pcm.dto.AppointExecution;
import co.jp.pcm.service.BookService;

public class BookServiceImplTest extends BaseTest {

	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception {
		long bookId = 1001;
		long studentId = 12345678910L;
		AppointExecution execution = bookService.appoint(bookId, studentId);
		System.out.println(execution);
	}

}