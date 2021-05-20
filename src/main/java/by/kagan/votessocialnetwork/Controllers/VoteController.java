package by.kagan.votessocialnetwork.Controllers;

import by.kagan.votessocialnetwork.DAOs.VoteDAO;
import by.kagan.votessocialnetwork.Models.User;
import by.kagan.votessocialnetwork.Models.Vote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VoteController {
    private VoteDAO voteDAO;
    public VoteController(VoteDAO voteDAO){
        this.voteDAO = voteDAO;
    }
    @GetMapping("/{id}/votes")
    public String toUserVoteList(@ModelAttribute User user){
        return "uservotelist";
    }
    @GetMapping("/new")
    public String toVoteCreateForm(Model model){
        return "createvoteform";
    }
    @PostMapping()
    public String createVote(@ModelAttribute("vote") Vote vote, @ModelAttribute("user") User user){
        return "redirect:/{id}/votes";
    }


}
