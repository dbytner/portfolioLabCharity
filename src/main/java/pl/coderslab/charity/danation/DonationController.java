package pl.coderslab.charity.danation;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.InstitutionRepository;
import pl.coderslab.charity.user.CurrentUser;
import pl.coderslab.charity.user.User;

@Controller

public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/donations")
    public String homeAction(Model model){
        model.addAttribute("categories", categoryRepository.findAllCategories());
        model.addAttribute("donations", new Donation());
        model.addAttribute("institutions", institutionRepository.findAllInstitutions());
        return "form";
    }

    @PostMapping("/add")
    public String save(Donation donation) {
        donationRepository.save(donation);
        return "form-confirmation";
    }


}
