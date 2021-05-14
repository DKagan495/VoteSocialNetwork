package by.kagan.votessocialnetwork.Controllers;

import by.kagan.votessocialnetwork.DAOs.UserDAO;
import by.kagan.votessocialnetwork.Models.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping()
@SessionAttributes(value = "user")
public class UserController {
    private final UserDAO userDAO;
    private boolean isLogIn = false;
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @GetMapping("/startpage")
    public String toStartPage(Model model){
       // user.setName("userName");
       // user.setPassword("123");
       // user.setEmail("emool");
       // if(user.getPassword() != null)
       //     return "personalpage";
       // else {
            model.addAttribute("user", new User());
            return "startpage";
       // }
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
            isLogIn = true;
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
        //System.out.println(user.getId());
        if(isLogIn){
            model.addAttribute("user", userDAO.showMyPage());

            return "personalpage";
        }
        else
            return "redirect:/startpage";
       // userDAO.showUserPage(user.getId());
        //return "userpage";
    }
    @GetMapping("/logout")
    public String logOut(SessionStatus sessionStatus){
        isLogIn = false;
        sessionStatus.setComplete();
        userDAO.logOut();
        return "redirect:/startpage";
    }
}
