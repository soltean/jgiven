package com.so.steps;

import com.so.Auction;
import com.so.Bid;
import com.so.Item;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class EvaluateBids extends Stage<EvaluateBids> {

    @ExpectedScenarioState
    private Auction auction;

    @ProvidedScenarioState
    private Bid winningBid;

    public EvaluateBids winning_bid_is_found_for(Item item) {
        winningBid = auction.getHighestBid(item);
        return self();
    }
}
