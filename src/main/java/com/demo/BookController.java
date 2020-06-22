package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @title  : Book 컨트롤러 클래스
 * @author : jaeha-dev (Git)
 * @memo   : @WebMvcTest를 위한 컨트롤러 클래스
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBookList(Model model) {
        model.addAttribute("bookList", bookService.getBookList());

        return "book";
    }
}