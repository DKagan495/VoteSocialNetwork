package by.kagan.votessocialnetwork.DAOs;

import by.kagan.votessocialnetwork.Models.Vote;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
public class VoteDAO {
    private String URL;
    private String USERNAME;
    private String PASSWORD;
    private int voteId;
    private Connection connection;
    public Vote showVote(int voteId){
        return null;
    }
    public void addVoteToDatabase(Vote vote){

    }
    public void editVote(Vote vote){

    }
    public void deleteVoid(int voteId){

    }
}
