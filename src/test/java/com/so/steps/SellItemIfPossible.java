package com.so.steps;

import com.so.Auction;
import com.so.Bid;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SellItemIfPossible extends Stage<SellItemIfPossible> {

    @ExpectedScenarioState
    private Bid winningBid;

    @ExpectedScenarioState
    private Auction auction;

    public void item_is_sold() {
        auction.sellItemIfPossible(winningBid);
        assertThat(winningBid.getItem().isSold(), is(true));
    }

    public void item_is_not_sold() {
        auction.sellItemIfPossible(winningBid);
        assertThat(winningBid.getItem().isSold(), is(false));
    }

}
