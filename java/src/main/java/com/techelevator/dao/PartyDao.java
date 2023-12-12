package com.techelevator.dao;

import com.techelevator.model.Party;

public interface PartyDao {

    Party getPartyByMonsterId(int monsterId);
}
