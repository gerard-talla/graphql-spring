package com.tallacoding.graphql_spring.Controller;

import com.tallacoding.graphql_spring.model.Author;
import com.tallacoding.graphql_spring.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    @QueryMapping
    public List<Author> findAllAuthor() {
        return authorService.findAllAuthor();
    }

    @QueryMapping
    public Author findOneAuthor(@Argument Integer id) {
        return authorService.findOneAuthor(id);
    }

    @MutationMapping
    public Author createAuthor(@Argument Author author) {
        return authorService.createAuthor(author);
    }

    @MutationMapping
    public Author updateAuthor(@Argument Integer id, @Argument Author author) {
        return authorService.updateAuthor(id, author);
    }

    @MutationMapping
    public void deleteAuthor(@Argument Integer id) {
        authorService.deleteAuthor(id);
    }


}
