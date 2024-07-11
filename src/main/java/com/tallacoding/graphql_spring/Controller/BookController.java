package com.tallacoding.graphql_spring.Controller;

import com.tallacoding.graphql_spring.model.Author;
import com.tallacoding.graphql_spring.model.Book;
import com.tallacoding.graphql_spring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @QueryMapping
    public Book findOne(@Argument Integer id) {
        return bookService.findOne(id);
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String isbn, @Argument List<Author> authors) {
        return bookService.createBook(title, isbn, authors);
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument String title, @Argument String isbn, @Argument List<Author> authors) {
        return bookService.updateBook(id, title, isbn, authors);
    }

    @MutationMapping
    public Boolean deleteBook(Integer id) {
        return bookService.deleteBook(id);
    }
}
