package com.weCode.bookStore.controller;

import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.service.BookService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    private List<Book> books;

    @BeforeEach
    void setUp(){
      books = new ArrayList<>();
    }


    @Test
    void shouldReturnAllBooksWhenGetAllBooksAreCalled(){
        books.add(getBook());
        when(bookService.getAllBooks()).thenReturn(books);
        ResponseEntity<List<Book>> books = bookController.getBooks();
        assertThat(books.getBody()).isNotNull();
        assertThat(books.getBody().size()).isEqualTo(1);
    }

    private Book getBook(){
        return Book.builder().title("Test Title")
                .description("test description")
                .releaseYear(2019)
                .id(UUID.randomUUID()).build();
    }
}
