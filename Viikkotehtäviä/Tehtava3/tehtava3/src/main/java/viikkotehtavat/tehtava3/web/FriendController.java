package viikkotehtavat.tehtava3.web;

import viikkotehtavat.tehtava3.domain.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FriendController {

    @GetMapping("/addfriend")
    public String showForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friendform";
    }

    @PostMapping("/addfriend")
    public String submitForm(@ModelAttribute Friend friend, Model model) {
        model.addAttribute("friend", friend);
        return "resultform"; 
    }
}