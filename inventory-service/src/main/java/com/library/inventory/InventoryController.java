package com.library.inventory;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    
    // Aquí simulamos el Singleton/Inventario en memoria
    private List<Book> books = new ArrayList<>(Arrays.asList(
        new Book("1", "Design Patterns"),
        new Book("2", "Clean Code")
    ));

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping("/add")
    public String addBook(@RequestBody String title) {
        // Aquí usaríamos tu Factory para crear el libro
        books.add(new Book(String.valueOf(books.size() + 1), title));
        return "Book added successfully!";
    }
}