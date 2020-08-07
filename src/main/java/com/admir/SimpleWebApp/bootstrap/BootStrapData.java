package com.admir.SimpleWebApp.bootstrap;

import com.admir.SimpleWebApp.domain.Author;
import com.admir.SimpleWebApp.domain.Book;
import com.admir.SimpleWebApp.domain.Publisher;
import com.admir.SimpleWebApp.repositories.AuthorRepository;
import com.admir.SimpleWebApp.repositories.BookRepository;
import com.admir.SimpleWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository=publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in bootStrap");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Save publisher count " + publisherRepository.count());

        Author eric = new Author("Eric","Andrew");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB" , "231241212512");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of books : " + bookRepository.count());
        System.out.println("Publisher number  of books : "+ publisher.getBooks().size());
    }
}
