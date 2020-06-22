package com.demo;

import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @title  : Book 서비스 인터페이스
 * @author : jaeha-dev (Git)
 * @memo   : @WebMvcTest를 위한 서비스 인터페이스
 */
@Service
public interface BookService {
    List<Book> getBookList();
}