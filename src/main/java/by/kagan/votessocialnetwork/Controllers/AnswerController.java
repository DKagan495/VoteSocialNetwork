package by.kagan.votessocialnetwork.Controllers;

import by.kagan.votessocialnetwork.DAOs.AnswerDAO;
import by.kagan.votessocialnetwork.Models.Answer;
import by.kagan.votessocialnetwork.Models.User;
import by.kagan.votessocialnetwork.Models.Vote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class AnswerController {
    static int ANSNUMBER;
    private final AnswerDAO answerDAO;
    public AnswerController(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }


    @GetMapping("/answers")
    public String toAnswersForm(Model model, @ModelAttribute("user") User user, @ModelAttribute("vote") Vote vote){
        ANSNUMBER = vote.getHowManyAnswers();
        for(int i = 0; i < vote.getHowManyAnswers(); i++) {
            answerDAO.addAnswerToDatabase(new Answer());
            model.addAttribute("answer", new Answer());
        }
        System.out.println(vote.getHowManyAnswers());
        model.addAttribute("answers", answerDAO.showTempList());
        return "createanswersform";
    }
    @PostMapping("/ans")
    public String sendAnswersForm (@ModelAttribute("answer") Answer answer){
       // System.out.println("hey = " + answer.getAnswerId());
        for(int i = 0; i < ANSNUMBER; i++) {
            answerDAO.createAnswer(i, answer);
            //System.out.println(answer.getAnswerContent());
        }
        return "redirect:/myvotes";
    }
    @GetMapping("/ans")
    public String toAnswers(Model model){
        model.addAttribute("answers", answerDAO.showAnswerList());
        return "takingpart";
    }
}
