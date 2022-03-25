package com.kandemirmert.bookstore.controller;

import com.kandemirmert.bookstore.dto.BookRequestDTO;
import com.kandemirmert.bookstore.dto.BookResponseDTO;
import com.kandemirmert.bookstore.entity.Book;
import com.kandemirmert.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/v1/book")
@RestController
@RequiredArgsConstructor
public class BookController {

    private  final BookService bookService;

    @GetMapping
   public ResponseEntity<BookResponseDTO> findBook(String name){

        return  ResponseEntity.ok(bookService.findBook(name));

    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAllBooks(){

        return ResponseEntity.ok(bookService.findAllBookList());
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam String name){
     bookService.deleteBook(name);
     return ResponseEntity.ok().build();
    }

}
