package com.weCode.bookStore.controller;

import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(){
      List<Book> books = bookService.getAllBooks();
      return ResponseEntity.ok(books);
    }
}
