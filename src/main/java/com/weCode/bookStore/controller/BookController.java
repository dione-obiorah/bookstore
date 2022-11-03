package com.weCode.bookStore.controller;

import com.weCode.bookStore.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @GetMapping()
    public ResponseEntity<List<Book>> getBook(){
        Book book = Book.builder().title("My first book").build();
        List<Book> books = new ArrayList<>();
        books.add(book);
        return ResponseEntity.ok(books);
    }
}
