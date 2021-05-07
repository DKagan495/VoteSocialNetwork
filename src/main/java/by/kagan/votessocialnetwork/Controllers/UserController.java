package by.kagan.votessocialnetwork.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/startpage")
public class UserController {
    @GetMapping()
    public String toTheStartPage(){
        return "startpage";
    }
}
