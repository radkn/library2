package com.lib.training.controller;

import com.lib.training.model.entities.Author;
import com.lib.training.model.entities.Book;
import com.lib.training.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/addbook")
    public String addBook(){
        return "book";
    }

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, @Valid Author author, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.mergeAttributes(ControllerUtil.getErrors(bindingResult));
            return "book";
        }

        List<Author> authors = new LinkedList<>();
        authors.add(author);
        book.setAuthors(authors);

        bookService.addBook(book);

        return "redirect:books";
    }

    @GetMapping("/books")
    public String books(Model model){
        Iterable<Book> books = bookService.getBooks();
        model.addAttribute("books", books);

        return "books";
    }
}
