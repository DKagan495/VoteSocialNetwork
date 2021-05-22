package by.kagan.votessocialnetwork.Controllers;

import by.kagan.votessocialnetwork.DAOs.VoteDAO;
import by.kagan.votessocialnetwork.Models.User;
import by.kagan.votessocialnetwork.Models.Vote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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

        model.addAttribute("vote", new Vote());
        return "createvoteform";
    }
    @PostMapping("/answers")
    public String createVote(@ModelAttribute("vote") Vote vote, @ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        vote.setUserId(user.getId());
        voteDAO.addVoteToDatabase(vote);
        redirectAttributes.addFlashAttribute("vote", vote);
        System.out.println(vote.getVoteName());
        return "redirect:/answers";
    }
    @GetMapping("/myvotes")
    public String toMyVotes(Model model){
        model.addAttribute("votes", voteDAO.showUserVotes());
        return "personalvotes";
    }


}
