package com.lib.training.model.repository;

import com.lib.training.model.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
