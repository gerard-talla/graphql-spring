package com.tallacoding.graphql_spring.repository;

import com.tallacoding.graphql_spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Integer> {

    @Override
    Optional<Book> findById(Integer integer);
}
