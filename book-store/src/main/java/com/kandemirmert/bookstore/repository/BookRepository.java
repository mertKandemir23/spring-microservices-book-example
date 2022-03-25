package com.kandemirmert.bookstore.repository;

import com.kandemirmert.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,String> {


    Optional<Book> findBookByBookName(String name);

}
