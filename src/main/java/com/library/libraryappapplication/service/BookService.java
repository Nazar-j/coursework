package com.library.libraryappapplication.service;

import com.library.libraryappapplication.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> getAllBooksSortedByAuthor();

    List<Book> getAllBooksSortedByYear();

    List<Book> getAllBooks();

    void deleteBook(String title, String firstName, String lastName);
}
