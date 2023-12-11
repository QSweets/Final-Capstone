package com.techelevator.model;

import java.time.LocalDate;

public class Vote {
    private int userId;
    private int partyId;
    private LocalDate date;
    private int voteId;
    private String monsterId;

    public Vote(int userId, int partyId, LocalDate date, int voteId, String monsterId){
        this.userId = userId;
        this.partyId = partyId;
        this.date = date;
        this.voteId = voteId;
        this.monsterId = monsterId;
    }

    public Vote(){};

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public int getVoteId() {
       return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(String monsterId) {
        this.monsterId = monsterId;
    }
}
