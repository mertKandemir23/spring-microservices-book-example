package com.kandemirmert.bookstore.handler;

import com.kandemirmert.bookstore.dto.BaseResponse;
import com.kandemirmert.bookstore.enums.BookMessageTypesEnum;
import com.kandemirmert.bookstore.exception.BookHasNotRecordToTheSystemException;
import com.kandemirmert.bookstore.exception.BookNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler{

   @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<BaseResponse> handleBoookNotFoundException(BookNotFoundException e) {
        return new ResponseEntity<>(BaseResponse.builder().code(BookMessageTypesEnum.BOOK_NOT_FOUND.getCode())
                .message(e.getMessage()).
                build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookHasNotRecordToTheSystemException.class)
    public ResponseEntity<BaseResponse> handleBookHasNotSaveToTheSystem(BookHasNotRecordToTheSystemException e) {
        return new ResponseEntity<>(BaseResponse.builder().code(BookMessageTypesEnum.BOOK_NOT_FOUND.getCode())
                .message(e.getMessage()).
                build(), HttpStatus.BAD_REQUEST);
    }
}
