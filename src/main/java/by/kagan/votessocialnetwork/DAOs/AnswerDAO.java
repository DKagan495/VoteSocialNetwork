package by.kagan.votessocialnetwork.DAOs;

import by.kagan.votessocialnetwork.Models.Answer;
import by.kagan.votessocialnetwork.Models.Vote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerDAO {
    static int COUNTER = 0;
    static int N_COUNTER = 0;
    private List<Answer> answerListTmp;{
        answerListTmp = new ArrayList<>();
    }
    private List<Answer> answerList;{
        answerList = new ArrayList<>();
    }
    public List<Answer> showAnswerList(){
        return answerList;
    }
    public List<Answer> showTempList(){
        return answerListTmp;
    }
    public void addAnswerToDatabase(Answer answer){
        answerListTmp.add(answer);
        System.out.println(answerListTmp.get(COUNTER).getAnswerContent());
        COUNTER++;
        answerListTmp.get(COUNTER-1).setAnswerId(COUNTER);
        System.out.println(answer.getAnswerId());
    }
    public void createAnswer(int answerId, Answer answer){
        System.out.println("govne " + answer.getAnswerContent());
        answer.setAnswerId(answerId);
        answerList.add(answerId, answer);
        System.out.println("Method is working!!!");
        System.out.println("brnfck" + answerList.get(answerId).getAnswerId());
        N_COUNTER++;
    }
}
