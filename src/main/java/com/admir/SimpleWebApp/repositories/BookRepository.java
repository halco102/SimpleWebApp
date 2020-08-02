package com.admir.SimpleWebApp.repositories;

import com.admir.SimpleWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
