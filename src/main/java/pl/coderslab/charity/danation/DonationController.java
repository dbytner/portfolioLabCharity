package pl.coderslab.charity.danation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class DonationController {

    @GetMapping("/donations")
    public String homeAction(Model model){

        return "form";
    }
}
