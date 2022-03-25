package com.kandemirmert.bookstore.dto;

import com.kandemirmert.bookstore.entity.Author;
import com.kandemirmert.bookstore.entity.Book;
import com.kandemirmert.bookstore.entity.BookCategories;
import com.kandemirmert.bookstore.entity.BookPublisher;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestDTO {

    String bookName;

    String pageNumber;

    BigDecimal amount;

    String releaseDate;

    Author author;

    List<BookCategories> bookCategoriesList;

    String currency;

    String description;

    BookPublisher bookPublisher;

    public static Book bookRequestToBook(BookRequestDTO book) {
        return Book.builder()
                .bookName(book.getBookName())
                .pageNumber(book.getPageNumber())
                .releaseDate(book.getReleaseDate())
                .author(book.getAuthor())
                .amount(book.getAmount())
                .bookSystemRecordCreatedTime(LocalDateTime.now())
                .bookCategoriesList(book.getBookCategoriesList())
                .currency(book.getCurrency())
                .description(book.getDescription())
                .bookPublisher(book.getBookPublisher())
                .bookSystemRecordUpdateTime(LocalDateTime.now()).build();


    }

}
