package com.library.libraryappapplication.controller;

import com.library.libraryappapplication.model.Book;
import com.library.libraryappapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String viewBooksPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam String title,
                             @RequestParam String firstName,
                             @RequestParam String lastName) {
        bookService.deleteBook(title, firstName, lastName);
        return "redirect:/books";
    }

    @GetMapping("/sorted-by-author")
    public String sortByAuthor(Model model) {
        model.addAttribute("books", bookService.getAllBooksSortedByAuthor());
        return "books";
    }

    @GetMapping("/sorted-by-year")
    public String sortByYear(Model model) {
        model.addAttribute("books", bookService.getAllBooksSortedByYear());
        return "books";
    }
}
