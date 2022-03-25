package com.kandemirmert.bookstore.service;

import com.kandemirmert.bookstore.dto.BookRequestDTO;
import com.kandemirmert.bookstore.dto.BookResponseDTO;
import com.kandemirmert.bookstore.entity.Book;
import com.kandemirmert.bookstore.exception.BookHasNotRecordToTheSystemException;
import com.kandemirmert.bookstore.exception.BookNotFoundException;
import com.kandemirmert.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepositoryImpl;


    public BookResponseDTO findBook(String name) {

        Optional<Book> optionalBook = bookRepositoryImpl.findBookByBookName(name);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return BookResponseDTO.bookToBookResponseDTO(book);
        } else
            throw new BookNotFoundException();
    }

    public List<BookResponseDTO> findAllBookList() {

        return BookResponseDTO.bookToBookResponseDTOList(bookRepositoryImpl.findAll());

    }

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {

        Book bookOptional = bookRepositoryImpl.save(BookRequestDTO.bookRequestToBook(bookRequestDTO));

        return BookResponseDTO.bookToBookResponseDTO(bookOptional);
    }

    public BookResponseDTO updateBook(BookRequestDTO bookRequestDTO) {

        Optional<Book> bookOptional = bookRepositoryImpl.findBookByBookName(bookRequestDTO.getBookName());
        if (bookOptional.isPresent()) {
            Book book = BookRequestDTO.bookRequestToBook(bookRequestDTO);
            book.setBookSystemRecordUpdateTime(LocalDateTime.now());
            return BookResponseDTO.bookToBookResponseDTO(bookRepositoryImpl.save(book));
        } else
            throw new BookHasNotRecordToTheSystemException();

    }

    public void deleteBook(String name) {
        Optional<Book> optionalBook = bookRepositoryImpl.findBookByBookName(name);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            bookRepositoryImpl.delete(book);
        } else
            throw new BookNotFoundException();
    }
}

