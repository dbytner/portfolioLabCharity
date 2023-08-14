package pl.coderslab.charity.danation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.InstitutionRepository;

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
        model.addAttribute("categories", categoryRepository.categoryNames());
        model.addAttribute("donations", new Donation());
        model.addAttribute("institutions", institutionRepository.findAllInstitutions());
        return "form";
    }


}
