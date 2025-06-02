package com.library.libraryappapplication.service;

import com.library.libraryappapplication.model.Book;
import com.library.libraryappapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    @Override
    public void deleteBook(String title, String firstName, String lastName) {
        bookRepository.deleteByTitleAndFirstNameAndLastName(title, firstName, lastName);
    }

    @Override
    public List<Book> getAllBooksSortedByAuthor() {
        return bookRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public List<Book> getAllBooksSortedByYear() {
        return bookRepository.findAllByOrderByPublishYearAsc();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
