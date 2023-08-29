package pl.coderslab.charity.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Controller
public class AdminController {
    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminController(InstitutionRepository institutionRepository, UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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
        model.addAttribute("institutions", institution);
        return "admin/institutionEdit";
    }

    @GetMapping("/admin/institution/delete/{id}")
    public String institutionDelete(@PathVariable long id, Model model){
        Institution institution = institutionRepository.find(id);
        model.addAttribute("institutions", institution);
        return "admin/institutionDelete";
    }
    @GetMapping("/admin/delete-confirm/{id}")
    public String delete(@PathVariable long id, Model model) {
        Institution institution = institutionRepository.find(id);
        institutionRepository.delete(institution);
        return "redirect:/admin/institutionList";
    }
    @GetMapping("/admin/adminsList")
    public String adminList(Model model){
        model.addAttribute("admins", userRepository.findAllUsersWithRole(roleRepository.findByName("ROLE_ADMIN")));
        return "admin/adminsList";
    }

    @GetMapping("/admin/add")
    public String adminAdd(Model model){
        model.addAttribute("admin", new User());
        return "admin/adminAdd";
    }
    @GetMapping("/admin/add/{id}")
    public String adminEdit(Model model){
        model.addAttribute("admin", new User());
        return "admin/adminEdit";
    }
    @PostMapping("/admin/institution/add")
    public String save(@Valid Institution institution, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "admin/institutionAdd";
        }
        institutionRepository.save(institution);
        return "redirect:/admin/institutionList";
    }
    @PostMapping("/admin/add")
    public String adminSave(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "admin/institutionAdd";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
        return "redirect:/admin/adminsList";
    }

    @PostMapping("/admin/institution/edit")
    public String edit(@Valid Institution institution, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "admin/institutionAdd";
        }
        institutionRepository.update(institution);
        return "redirect:/admin/institutionList";
    }
    @PostMapping("/admin/edit")
    public String adminEdit(@Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "admin/institutionAdd";
        }
        userRepository.save(user);
        return "redirect:/admin/adminsList";
    }
}
