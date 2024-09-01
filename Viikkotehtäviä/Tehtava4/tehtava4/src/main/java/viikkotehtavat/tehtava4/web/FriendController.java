package viikkotehtavat.tehtava4.web;

import viikkotehtavat.tehtava4.domain.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {

    private List<Friend> friendList = new ArrayList<>();

    @GetMapping("/addfriend")
    public String showForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friendform";
    }

    @PostMapping("/addfriend")
    public String submitForm(@ModelAttribute Friend friend) {
        friendList.add(friend);
        return "redirect:/friends";
    }

    @GetMapping("/friends")
    public String showFriends(Model model) {
        model.addAttribute("friends", friendList);
        return "friendlist";
    }
}