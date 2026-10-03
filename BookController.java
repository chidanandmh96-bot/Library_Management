package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // CREATE
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // READ ALL
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {

        Book existingBook = repository.findById(id).orElse(null);

        if (existingBook != null) {

            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            existingBook.setCategory(book.getCategory());

            return repository.save(existingBook);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        repository.deleteById(id);

        return "Book deleted successfully";
    }
}