package com.admir.SimpleWebApp.repositories;

import com.admir.SimpleWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author,Long>{


}
