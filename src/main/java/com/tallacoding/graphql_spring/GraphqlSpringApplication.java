package com.tallacoding.graphql_spring;

import com.tallacoding.graphql_spring.model.Author;
import com.tallacoding.graphql_spring.model.Book;
import com.tallacoding.graphql_spring.model.Profession;
import com.tallacoding.graphql_spring.service.AuthorService;
import com.tallacoding.graphql_spring.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GraphqlSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner fill_Database_With_Dummy(AuthorService authorService, BookService bookService) {
		return (args) -> {
			Author author1 = Author.builder().name("Test1").profession(Profession.SOFTWARE_DEVELOPER).build();
			Author author2 = Author.builder().name("Test2").profession(Profession.SCRUM_MASTER).build();
			Author author3 = Author.builder().name("Test3").profession(Profession.SOFTWARE_ARCHITECT).build();
			authorService.createAuthor(author1);
			authorService.createAuthor(author2);
			authorService.createAuthor(author3);

			Book book1 = Book.builder().title("Spring Boot and Graphql").isbn("978-3-12-735474-4")
					.authors(List.of(author1, author2)).build();
			Book book2 = Book.builder().title("AWS Developer").isbn("978-3-12-735474-0")
					.authors(List.of(author3)).build();

			bookService.createBook("Spring Boot and Graphql", "978-3-12-735474-4", List.of(author1, author2));
			bookService.createBook("AWS Developer", "978-3-12-735474-3", List.of(author3));
		};
	}

}
