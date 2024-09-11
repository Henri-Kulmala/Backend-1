package bookstore.code;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    
    @GetMapping("/index")
    public String getParams(@RequestParam String param) {
        return "/index";
    }
    
    @GetMapping("/booklist")
    public String getBooks(Model model) {
    model.addAttribute("books", repository.findAll());
    return "booklist";
    
    }

    @GetMapping("/add")
    public String addBook(Model model) {
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



}
