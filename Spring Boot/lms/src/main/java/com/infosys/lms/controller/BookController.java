package com.infosys.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infosys.lms.entity.Book;
import com.infosys.lms.responsestructure.ResponseStructure;
import com.infosys.lms.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseStructure<Book> saveBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @GetMapping
    public ResponseStructure<List<Book>> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseStructure<Book> getBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseStructure<String> deleteBookById(@PathVariable int id) {
        return service.deleteBookById(id);
    }

    @GetMapping("/name/{name}")
    public ResponseStructure<List<Book>> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/author/{authorName}")
    public ResponseStructure<List<Book>> findByAuthor(@PathVariable String authorName) {
        return service.findByAuthorName(authorName);
    }

    @GetMapping("/category/{category}")
    public ResponseStructure<List<Book>> findByCategory(@PathVariable String category) {
        return service.findByCategory(category);
    }
}



