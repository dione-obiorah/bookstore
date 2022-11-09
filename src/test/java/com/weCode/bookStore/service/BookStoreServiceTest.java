package com.weCode.bookStore.service;

import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookStoreServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    private List<Book> books;

    @BeforeEach
    void setUp(){
        books = new ArrayList<>();
        books.add(getBook());
    }

    @Test
    void shouldReturnAllBooks(){
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> response = bookService.getAllBooks();
        assertThat(1).isEqualTo(books.size());
        assertEquals("Test Title", response.get(0).getTitle());
        assertEquals("test description", response.get(0).getDescription());
        assertEquals(2019, response.get(0).getReleaseYear());
    }

    private Book getBook(){
        return Book.builder().title("Test Title")
                .description("test description")
                .releaseYear(2019)
                .id(UUID.randomUUID()).build();
    }


}
