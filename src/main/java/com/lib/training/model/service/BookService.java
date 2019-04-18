package com.lib.training.model.service;

import com.lib.training.model.entities.Book;
import com.lib.training.model.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookUnitService bookUnitService;

    public boolean addBook(Book book){
        Book book1 = bookRepository.findBookByTitle(book.getTitle());
        boolean absent = book1==null;
        if(absent){
            book.setTotal_amount(book.getTotal_amount()+1);
            book.setAmount_of_free(book.getAmount_of_free()+1);
            bookRepository.save(book);
        }

        bookUnitService.addBookUnit(book);
        return absent;
    }

    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

}
