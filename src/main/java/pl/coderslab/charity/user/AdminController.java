package pl.coderslab.charity.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.danation.Donation;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String homeAction(){

        return "admin";
    }
}
