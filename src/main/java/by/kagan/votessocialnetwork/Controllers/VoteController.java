package by.kagan.votessocialnetwork.Controllers;

import by.kagan.votessocialnetwork.DAOs.VoteDAO;
import by.kagan.votessocialnetwork.Models.Answer;
import by.kagan.votessocialnetwork.Models.User;
import by.kagan.votessocialnetwork.Models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("vote")
public class VoteController {
    private VoteDAO voteDAO;
    @Autowired
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
    public String createVote(@ModelAttribute("vote") @Valid Vote vote, BindingResult bindingResult, @ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors())
            return "createvoteform";
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
    @GetMapping("/answers")
    public String toMyAnswers(Model model, @ModelAttribute("vote") Vote vote, @ModelAttribute("user") User user){
        vote.setUserId(user.getId());
        System.out.println("user id = " + vote.getUserId());
        System.out.println(vote.getHowManyAnswers());
        model.addAttribute("answers", voteDAO.showMyAnswers(vote));

        return "takingpart";
    }
    @GetMapping("/see")
    public String toTakePart(Model model, @ModelAttribute("vote") Vote vote){
        model.addAttribute("answers", voteDAO.viewOfMyAnswers());
        return "takingpart";
    }
    @GetMapping("/setanswers")
    public String toEditAnswers(Model model, @ModelAttribute("vote") Vote vote){
        model.addAttribute("answers", voteDAO.viewOfMyAnswers());
        for(int i = 0; i < 2; i++){
            System.out.println("It is: " + voteDAO.viewOfMyAnswers().get(i).getAnswerContent());
        }
        return "setanswers";
    }
    @PostMapping("/sucreated")
    public String doEditAnswers(@ModelAttribute("answers") List<Answer> answerList, @ModelAttribute("vote") Vote vote){
        voteDAO.editAnswers(answerList, vote);
        return "redirect:/sucreated";
    }

}
