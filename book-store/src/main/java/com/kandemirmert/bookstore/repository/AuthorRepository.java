package com.kandemirmert.bookstore.repository;

import com.kandemirmert.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,String> {
}
