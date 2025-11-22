package com.example.itemcared.itemcard.exception;

import com.example.itemcared.itemcard.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;


//let spring boot know that theres a custom global exception handler XD
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(ItemFoundExeption.class)
    public ResponseEntity<String> handleItemFoundException(ItemFoundExeption ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }
    @ExceptionHandler(CategoryFoundException.class)
    public ResponseEntity<String> handleCategoryFoundException(CategoryFoundException ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        System.out.println(ex.getMessage());
        return ResponseEntity.status(500).body("An unexpected error occurred: ");
    }
}
