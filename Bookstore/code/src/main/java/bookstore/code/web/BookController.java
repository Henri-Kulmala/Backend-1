package bookstore.code.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.code.domain.Book;
import bookstore.code.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/")
    public String home(Model model) {
       
        if (!isUserLoggedIn()) {
            return "redirect:/login";
        }
        return getBooks(model);  
    }

    @GetMapping("/login")
    public String login() {
        return "login"; 
    }

    @GetMapping("/booklist")
    public String getBooks(Model model) {
       
        if (!isUserLoggedIn()) {
            return "redirect:/login";
        }
        List<Book> books = (List<Book>) repository.findAll();
        model.addAttribute("books", books); 
        return "booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        
        if (!isUserLoggedIn()) {
            return "redirect:/login";
        }
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = repository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "editbook";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";   
    }

    
    private boolean isUserLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.isAuthenticated();
    }
}
