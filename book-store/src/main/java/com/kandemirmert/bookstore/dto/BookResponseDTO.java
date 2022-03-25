package com.kandemirmert.bookstore.dto;

import com.kandemirmert.bookstore.entity.Author;
import com.kandemirmert.bookstore.entity.Book;
import com.kandemirmert.bookstore.entity.BookCategories;
import com.kandemirmert.bookstore.entity.BookPublisher;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDTO {

    String bookName;

    String pageNumber;

    BigDecimal amount;

    BookPublisher bookPublisher;

    String releaseDate;

    Author author;

    List<BookCategories> bookCategoriesList;

    String currency;

    String description;


    public static BookResponseDTO bookToBookResponseDTO(Book book) {
        return BookResponseDTO.builder()
                .bookName(book.getBookName())
                .pageNumber(book.getPageNumber())
                .releaseDate(book.getReleaseDate())
                .bookPublisher(book.getBookPublisher())
                .amount(book.getAmount())
                .author(book.getAuthor())
                .bookCategoriesList(book.getBookCategoriesList())
                .currency(book.getCurrency())
                .description(book.getDescription())
                .build();
    }

    public static  List<BookResponseDTO> bookToBookResponseDTOList(List<Book> bookList) {
        return bookList.stream().map(book -> bookToBookResponseDTO(book)).collect(Collectors.toList());

    }
}
