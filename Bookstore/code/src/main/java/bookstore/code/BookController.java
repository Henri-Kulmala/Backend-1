package bookstore.code;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @RequestMapping(value= {"/", "/booklist"})
    public String BookList(Model model) {
    model.addAttribute("books", repository.findAll());
    return "booklist";
    

    }
}
