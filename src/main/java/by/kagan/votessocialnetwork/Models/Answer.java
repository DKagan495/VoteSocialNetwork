package by.kagan.votessocialnetwork.Models;

public class Answer {
    private int userId;
    private int voteId;
    private int answerId;
    private String answerContent;
    public Answer(){

    }
    public Answer(int userId, int voteId, int answerId, String answerContent){
        this.userId = userId;
        this.voteId = voteId;
        this.answerId = answerId;
        this.answerContent = answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
