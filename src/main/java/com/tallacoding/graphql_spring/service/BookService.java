package com.tallacoding.graphql_spring.service;

import com.tallacoding.graphql_spring.model.Author;
import com.tallacoding.graphql_spring.model.Book;
import com.tallacoding.graphql_spring.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book createBook(String title, String isbn, List<Author> authors) {
        Book book = Book.builder()
                .title(title)
                .isbn(isbn)
                .authors(authors)
                .build();
        return bookRepo.save(book);
    }

    public Book findOne(Integer id) {
        return bookRepo.findById(id).orElseThrow(null);
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Boolean deleteBook(Integer id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book.isPresent()) {
            bookRepo.delete(book.get());
            return true;
        }
        return false;
    }

    public Book updateBook(Integer id, String title, String isbn, List<Author> authors) {
        Optional<Book> book = bookRepo.findById(id);

        if (book.isPresent()) {
            book = Optional.of(Book.builder()
                    .title(title)
                    .isbn(isbn)
                    .authors(authors)
                    .build());

        } else {
            throw new IllegalArgumentException("Invalid Book");
        }

        return book.get();
    }
}
