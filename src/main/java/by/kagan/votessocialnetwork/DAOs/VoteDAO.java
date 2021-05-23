package by.kagan.votessocialnetwork.DAOs;

import by.kagan.votessocialnetwork.Models.Answer;
import by.kagan.votessocialnetwork.Models.Vote;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Component
public class VoteDAO {
    private String URL;
    private String USERNAME;
    private String PASSWORD;
    private int voteId = 0;
    private int userId;
    private Connection connection;
    private List<Vote> voteList;{
        voteList = new ArrayList<>();

    }
    private List<Answer> answerList;{
        answerList = new ArrayList<>();
    }
    public Vote showVote(int voteId){
        return null;
    }
    public void addVoteToDatabase(Vote vote){
        voteId++;
        vote.setVoteId(voteId);
        voteList.add(vote);
    }
    public void editVote(Vote vote){

    }
    public void deleteVote(int voteId){

    }
    public List<Vote> showUserVotes(){
        return voteList;
    }
    public List<Answer> showMyAnswers(Vote vote){
        System.out.println("answers in vote: " + vote.getHowManyAnswers());
        for(int i = 0; i < vote.getHowManyAnswers(); i++) {
            answerList.add(i, new Answer(userId, voteId, i, false, "Your Answer"+i));
            System.out.println(answerList.get(i).getAnswerContent());
        }
        return answerList;
    }
    public void editAnswers(List<Answer> editedAnswers, Vote vote){
        List<Answer> listToEdit = showMyAnswers(vote);
        for(int i =0; i < vote.getHowManyAnswers(); i++){
            listToEdit.add(i, editedAnswers.get(i));
        }
    }
    public List<Answer> viewOfMyAnswers(){
        return answerList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
