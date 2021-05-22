package by.kagan.votessocialnetwork.Models;

//import jdk.internal.org.jline.utils.AnsiWriter;

import java.util.ArrayList;
import java.util.List;

public class Vote {
    private int userId;
    private int voteId;
    private String voteName;
    private boolean voteType;
    private boolean anonStatus;
    private boolean canUserBeAnonymous;
    private int availibleNumberOfAnswers;
    private int howManyAnswers;
    private boolean availibleToUndoUserChoose;
    private int usersAnswerId;
    public Vote(){

    }

    public Vote(int voteId, String voteName, boolean anonStatus, boolean voteType, boolean canUserBeAnonymous, int availibleNumberOfAnswers, int howManyAnswers, boolean availibleToUndoUserChoose, int usersAnswerId) {
        this.voteId = voteId;
        this.voteName = voteName;
        this.anonStatus = anonStatus;
        this.voteType = voteType;
        this.canUserBeAnonymous = canUserBeAnonymous;
        this.availibleNumberOfAnswers = availibleNumberOfAnswers;
        this.howManyAnswers = howManyAnswers;
        this.availibleToUndoUserChoose = availibleToUndoUserChoose;
        this.usersAnswerId = usersAnswerId;
    }

    public boolean isVoteType() {
        return voteType;
    }

    public void setVoteType(boolean voteType) {
        this.voteType = voteType;
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
