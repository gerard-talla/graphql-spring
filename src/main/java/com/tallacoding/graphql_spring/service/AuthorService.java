package com.tallacoding.graphql_spring.service;

import com.tallacoding.graphql_spring.model.Author;
import com.tallacoding.graphql_spring.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    public Author findOneAuthor(Integer id) {
        return authorRepo.findById(id).orElseThrow(null);
    }

    public Author updateAuthor(Integer id, Author author) {
        Optional<Author> authorOptional = authorRepo.findById(id);
        if (authorOptional.isPresent()) {
            authorOptional = Optional.of(Author.builder()
                    .name(author.getName())
                    .profession(author.getProfession())
                    .build());
        } else {
            throw new IllegalArgumentException("Invalid Author");
        }

        return authorRepo.save(authorOptional.get());
    }

    public Boolean deleteAuthor(Integer id) {
        Optional<Author> author = authorRepo.findById(id);
        if (author.isPresent()) {
            authorRepo.delete(author.get());
            return true;
        }
        return false;
    }

    public List<Author> findAllAuthor() {
        return authorRepo.findAll();
    }
}
