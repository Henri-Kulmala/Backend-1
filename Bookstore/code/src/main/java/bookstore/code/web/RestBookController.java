package bookstore.code.web;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



import bookstore.code.domain.Book;
import bookstore.code.domain.BookRepository;

@RestController
@RequestMapping("/api/books")
public class RestBookController {

    @Autowired
    private BookRepository repository;



    @GetMapping
    public List<Book> getAllBooks() {
        return (List<Book>) repository.findAll(); 
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
    return repository.findById(id).orElse(null); 
    }
}
