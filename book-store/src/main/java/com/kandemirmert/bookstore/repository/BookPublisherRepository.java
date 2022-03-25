package com.kandemirmert.bookstore.repository;

import com.kandemirmert.bookstore.entity.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookPublisherRepository extends JpaRepository<BookPublisher,String> {
}
