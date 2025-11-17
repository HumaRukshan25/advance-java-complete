package com.infosys.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.lms.dao.BookDao;
import com.infosys.lms.entity.Book;
import com.infosys.lms.responsestructure.ResponseStructure;

@Service
public class BookService {

    @Autowired
    private BookDao dao;

    public ResponseStructure<Book> saveBook(Book book) {
        return new ResponseStructure<>(200, "Book saved successfully", dao.saveBook(book));
    }

    public ResponseStructure<List<Book>> getAllBooks() {
        return new ResponseStructure<>(200, "Books fetched successfully", dao.getAllBooks());
    }

    public ResponseStructure<Book> getBookById(int id) {
        return dao.getBookById(id)
                .map(book -> new ResponseStructure<>(200, "Book found", book))
                .orElse(new ResponseStructure<>(404, "Book not found", null));
    }

    public ResponseStructure<String> deleteBookById(int id) {
        dao.deleteBookById(id);
        return new ResponseStructure<>(200, "Book deleted successfully", "Deleted book with id: " + id);
    }

    public ResponseStructure<List<Book>> findByName(String name) {
        return new ResponseStructure<>(200, "Books with name: " + name, dao.findByName(name));
    }

    public ResponseStructure<List<Book>> findByAuthorName(String authorName) {
        return new ResponseStructure<>(200, "Books by author: " + authorName, dao.findByAuthorName(authorName));
    }

    public ResponseStructure<List<Book>> findByCategory(String category) {
        return new ResponseStructure<>(200, "Books in category: " + category, dao.findByCategory(category));
    }
}
