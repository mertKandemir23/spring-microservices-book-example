package com.kandemirmert.bookstore.repository;

import com.kandemirmert.bookstore.entity.BookCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoriesRepository extends JpaRepository<BookCategories,String> {
}
