package com.techelevator.dao;

import com.techelevator.model.Party;

import java.util.List;

public interface PartyDao {

    Party createParty(Party party, int characterId);

    Party getPartyByPartyId(int partyId);

    List<Party> getAllParties();

//    For future scalability
//    Party deleteParty(int partyId);
//    Party updateParty(int partyId);


}
