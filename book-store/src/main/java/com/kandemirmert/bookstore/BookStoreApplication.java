package com.kandemirmert.bookstore;

import com.kandemirmert.bookstore.entity.Address;
import com.kandemirmert.bookstore.entity.Author;
import com.kandemirmert.bookstore.entity.Book;
import com.kandemirmert.bookstore.entity.BookCategories;
import com.kandemirmert.bookstore.repository.AddressRepository;
import com.kandemirmert.bookstore.repository.AuthorRepository;
import com.kandemirmert.bookstore.repository.BookCategoriesRepository;
import com.kandemirmert.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@EnableEurekaClient
@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookCategoriesRepository bookCategoriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        /**
         * @OneToOne
         */
/*        Author author = Author.builder()
                .authorAge("43")
                .authorBirthDay("22-09-1974")
                .authorName("Mert")
                .authorSurname("Kandemir")
                .build();

        Address address = Address.builder()
                .author(author)
                .zipCode("34000")
                .town("Kağıthane")
                .doorNumber("4")
                .country("Türkiye")
                .city("İstanbul")
                .street("Aslan")
                .build();

        addressRepository.save(address);
        System.out.println(address);*/

        /**
         * @OneToMany
         *
         */
        Author author = Author.builder()
                .authorAge("43")
                .authorBirthDay("22-09-1974")
                .authorName("Mert")
                .authorSurname("Kandemir")
                .build();
/*

        BookCategories bookCategories = BookCategories.builder()
                .name("Biography")
                .build();


        List<BookCategories> bookCategoriesList = new ArrayList<>();
        bookCategoriesList.add(bookCategories);


        bookCategoriesList.add(bookCategories);




        bookCategoriesRepository.save(bookCategories);

        bookRepository.save(book);
*/


        BookCategories bookCategories = BookCategories.builder()
                .name("Biography")
                .build();


        Book book = Book.builder()
                .bookName("Einstein")
                .bookSystemRecordCreatedTime(LocalDateTime.now())
                .bookSystemRecordUpdateTime(LocalDateTime.now())
                .amount(BigDecimal.valueOf(12.3))
                .publisher("x")
                .currency("try")
                .bookCategoriesList(List.of(bookCategories))
                .build();

        bookRepository.save(book);

    }
}