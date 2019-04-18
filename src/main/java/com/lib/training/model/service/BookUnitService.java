package com.lib.training.model.service;

import com.lib.training.model.entities.Book;
import com.lib.training.model.entities.BookUnit;
import com.lib.training.model.repository.BookUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BookUnitService {

    @Autowired
    private BookUnitRepository bookUnitRepository;

    public BookUnit addBookUnit(Book book){
        return bookUnitRepository.save(new BookUnit(book));
    }
}
