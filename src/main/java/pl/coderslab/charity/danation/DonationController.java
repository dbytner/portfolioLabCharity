package pl.coderslab.charity.danation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.category.CategoryRepository;

import java.util.List;

@Controller

public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/donations")
    public String homeAction(Model model){
        model.addAttribute("categories", categoryRepository.categoryNames());
        return "form";
    }


}
