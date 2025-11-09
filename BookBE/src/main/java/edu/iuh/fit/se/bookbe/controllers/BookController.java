package edu.iuh.fit.se.bookbe.controllers;

import edu.iuh.fit.se.bookbe.dtos.ApiResponse;
import edu.iuh.fit.se.bookbe.entities.Book;
import edu.iuh.fit.se.bookbe.services.IBookService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   10/30/2025
 * Time:   11:22 AM
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final IBookService service;


    public BookController(IBookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>>all(){
        return ResponseEntity.ok(ApiResponse.ok((List<Book>) service.findAll()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> one (@PathVariable Integer id){
        Book b = service.findById(id);
        return  ResponseEntity.ok(ApiResponse.ok(b));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Book>> create(@Valid @RequestBody Book b){
        return ResponseEntity.status(201).body(ApiResponse.created(service.create(b)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> update(@PathVariable Integer id, @Valid @RequestBody Book b){
        return ResponseEntity.ok(ApiResponse.ok(service.update(id, b)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok(new ApiResponse<>(200,"DELETED",null));
    }

}