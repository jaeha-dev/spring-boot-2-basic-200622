package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.Collections;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @title  : @WebMvcTest
 * @author : jaeha-dev (Git)
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class) // 테스트 대상 클래스 명시
public class WebMvcTestBookControllerTests {

    @Autowired
    private MockMvc mvc; // BookController 관련 빈만 로드하여 MVC 테스트 수행

    @MockBean
    private BookService bookService; // BookService의 구현체 없이 목 객체로 대체하여 테스트 동작 지정

    @Test
    public void Book_MVC_테스트() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());

        // bookService(목 객체)에 getBookList() 메소드를 요청하면 book 객체가 담긴 리스트를 반환할 것이다.
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));

        // /books URL에 GET 요청을 전송한다.
        mvc.perform(get("/books"))
           // HTTP 상태값이 200 Ok인지 확인
           .andExpect(status().isOk())
           // 반환되는 View 이름 (book.jsp 등) 확인
           .andExpect(view().name("book"))
           // Model에 담긴 프로퍼티 이름 존재 여부
           .andExpect(model().attributeExists("bookList"))
           // Model에 담긴 프로퍼티에서 bookList에 book 객체가 담겨져 있는지 확인
           .andExpect(model().attribute("bookList", contains(book)));
    }
}