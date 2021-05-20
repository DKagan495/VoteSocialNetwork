package by.kagan.votessocialnetwork.Models;

public class Vote {
    private int voteId;
    private String voteName;
    private boolean anonStatus;
    private boolean canUserBeAnonymous;
    private int availibleNumberOfAnswers;
    private int howManyAnswers;
    private boolean availibleToUndoUserChoose;
    private int usersAnswerId;
    public Vote(){

    }

    public Vote(int voteId, String voteName, boolean anonStatus, boolean canUserBeAnonymous, int availibleNumberOfAnswers, int howManyAnswers, boolean availibleToUndoUserChoose, int usersAnswerId) {
        this.voteId = voteId;
        this.voteName = voteName;
        this.anonStatus = anonStatus;
        this.canUserBeAnonymous = canUserBeAnonymous;
        this.availibleNumberOfAnswers = availibleNumberOfAnswers;
        this.howManyAnswers = howManyAnswers;
        this.availibleToUndoUserChoose = availibleToUndoUserChoose;
        this.usersAnswerId = usersAnswerId;

    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public boolean isAnonStatus() {
        return anonStatus;
    }

    public void setAnonStatus(boolean anonStatus) {
        this.anonStatus = anonStatus;
    }

    public boolean isCanUserBeAnonymous() {
        return canUserBeAnonymous;
    }

    public void setCanUserBeAnonymous(boolean canUserBeAnonymous) {
        this.canUserBeAnonymous = canUserBeAnonymous;
    }

    public int getAvailibleNumberOfAnswers() {
        return availibleNumberOfAnswers;
    }

    public void setAvailibleNumberOfAnswers(int availibleNumberOfAnswers) {
        this.availibleNumberOfAnswers = availibleNumberOfAnswers;
    }

    public int getHowManyAnswers() {
        return howManyAnswers;
    }

    public void setHowManyAnswers(int howManyAnswers) {
        this.howManyAnswers = howManyAnswers;
    }

    public boolean isAvailibleToUndoUserChoose() {
        return availibleToUndoUserChoose;
    }

    public void setAvailibleToUndoUserChoose(boolean availibleToUndoUserChoose) {
        this.availibleToUndoUserChoose = availibleToUndoUserChoose;
    }

    public int getUsersAnswerId() {
        return usersAnswerId;
    }

    public void setUsersAnswerId(int usersAnswerId) {
        this.usersAnswerId = usersAnswerId;
    }
}
