package by.kagan.votessocialnetwork.DAOs;

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
    private Connection connection;
    private List<Vote> voteList;{
        voteList = new ArrayList<>();
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
}
