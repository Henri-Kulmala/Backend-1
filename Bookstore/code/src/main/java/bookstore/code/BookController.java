package bookstore.code;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

    @GetMapping("/index")
    public String getParams(@RequestParam String param) {
        return "/index";
    }
    

=======
public class BookController {

>>>>>>> origin/bookstore1
}
