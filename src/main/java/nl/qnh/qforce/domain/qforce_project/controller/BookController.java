package nl.qnh.qforce.domain.qforce_project.controller;

import nl.qnh.qforce.domain.qforce_project.model.Book;
import nl.qnh.qforce.domain.qforce_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks(@RequestParam(name="title", defaultValue="") String title) {
        return ResponseEntity.ok(bookService.getBooks(title));   // Jackson  object => json
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        int newId = bookService.addBook(book);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).build();
    }

}
