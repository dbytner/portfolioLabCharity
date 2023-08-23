package pl.coderslab.charity.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String save(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}
