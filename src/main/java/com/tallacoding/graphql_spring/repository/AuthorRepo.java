package com.tallacoding.graphql_spring.repository;

import com.tallacoding.graphql_spring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
