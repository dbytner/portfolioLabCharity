package pl.coderslab.charity.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import javax.validation.Valid;

@Controller
public class AdminController {
    private final InstitutionRepository institutionRepository;

    public AdminController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/admin")
    public String homeAction(){
        return "admin/admin";
    }

    @GetMapping("/admin/institutionList")
    public String list(Model model){
        model.addAttribute("institutions", institutionRepository.findAllInstitutions());
        return "admin/list";
    }

    @GetMapping("/admin/institution/add")
    public String add(Model model){
        model.addAttribute("institutions", new Institution());
        return "admin/institutionAdd";
    }
    @GetMapping("/admin/institution/edit/{id}")
    public String institutionEdit(@PathVariable long id, Model model){
        Institution institution = institutionRepository.find(id);
        model.addAttribute("institution", institution);
        return "admin/institutionEdit";
    }

    @PostMapping("/admin/institution/add")
    public String save(@Valid Institution institution, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "admin/institutionAdd";
        }
        institutionRepository.save(institution);
        return "redirect:/admin/institutionList";
    }
}
