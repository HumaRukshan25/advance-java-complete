package com.infosys.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.lms.entity.Book;
import com.infosys.lms.repository.BookRepository;

@Repository
public class BookDao {

    @Autowired
    private BookRepository repo;

    public Book saveBook(Book book) {
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return repo.findById(id);
    }

    public void deleteBookById(int id) {
        repo.deleteById(id);
    }

    public List<Book> findByName(String name) {
        return repo.findByName(name);
    }

    public List<Book> findByAuthorName(String authorName) {
        return repo.findByAuthorName(authorName);
    }

    public List<Book> findByCategory(String category) {
        return repo.findByCategory(category);
    }
}
