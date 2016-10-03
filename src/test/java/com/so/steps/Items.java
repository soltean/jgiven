package com.so.steps;

import com.so.Auction;
import com.so.Item;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExtendedDescription;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Items extends Stage<Items> {

    @ProvidedScenarioState
    private Auction auction;

    @ExtendedDescription("Some items need to be sell at the auction")
    public Items items_are_presented_at_auction(List<Item> items) {
        auction = new Auction();
        auction.addItems(items);
        assertThat(auction.getItems().size(), is(2));
        return self();
    }
}
