package com.so;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Auction {

    private List<Bid> bids;
    private List<Item> items;

    public void sendBidForItem(Item item, int amount) {
        Bid bid = new Bid(item, amount);
        bids = Optional.ofNullable(bids).orElse(new ArrayList<>());
        bids.add(bid);
    }

    public Bid getHighestBid(Item item) {
        return bids.stream()
                .filter(bid -> bid.getItem().getCode().equals(item.getCode()))
                .max(Comparator.comparing(bid -> bid.getAmount()))
                .get();
    }

    public void sellItemIfPossible(Bid bid) {
        Item item = bid.getItem();
        if (bid.getAmount() < item.getReservePrice()) {
            item.setSold(true);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void addItems(List<Item> items) {
        this.items = items;
    }
}
