package com.so.steps;

import com.so.Auction;
import com.so.Item;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExtendedDescription;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Bids extends Stage<Bids> {

    @ProvidedScenarioState
    private Auction auction;

    @ExtendedDescription("Bids need to be made in order to buy items")
    public Bids bids_are_being_made_for_items(List<Item> items) {
        items.stream().forEach(item -> makeBidsForItem(item));
        assertThat(auction.getBids().size(), is(10));
        return self();
    }

    private void makeBidsForItem(Item item) {
        for (int i = 0; i < 5; i++) {
            auction.sendBidForItem(item, ThreadLocalRandom.current().nextInt(1500, 2000));
        }
    }

}
