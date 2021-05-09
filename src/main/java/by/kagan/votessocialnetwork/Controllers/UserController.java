package by.kagan.votessocialnetwork.Controllers;

import by.kagan.votessocialnetwork.DAOs.UserDAO;
import by.kagan.votessocialnetwork.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/startpage")
    public String toStartPage(Model model){
        model.addAttribute("user", new User());
        return "startpage";
    }
    @GetMapping("/registration")
    public String toRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "registrationform";
    }
    @PostMapping("/registration")
    public String doRegistration(@ModelAttribute("user") User user){
        userDAO.addUserToDatabase(user);
        //userDAO.regTest();
        return "successregistraion";
    }
    @GetMapping("/successregistration")
    public String afterSuccessRegistration(){
        return "successregistraion";
    }
    @GetMapping("/userlist")
    public String showUserList(Model model){
        model.addAttribute("users", userDAO.showUserList());
        return "userlist";
    }
    @PostMapping("/suclogpage")
    public String doLogin(@ModelAttribute("user") User user){
        if(userDAO.tryToLogInAccount(user)) {
            return "redirect:/suclogpage";
        }
        else {
            user.setLogInSuccessful(true);
            return "startpage";
        }
    }
    @GetMapping("/suclogpage")
    public String toSuccessfulLogInPage(){
        return "suclog";
    }
    @GetMapping("/{id}")
    public String toUserPage(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDAO.showUserPage(id));
        return "userpage";
    }
    @GetMapping("/mypage")
    public String toMyPage(Model model){
        model.addAttribute("user", userDAO.showMyPage());
        return "personalpage";
    }
}
