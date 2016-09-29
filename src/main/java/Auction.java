import java.util.*;
import java.util.stream.Collectors;

public class Auction {

    private List<Bid> bids;
    private List<Item> items;

    public void sendBidForItem(Item item, int amount) {
        Bid bid = new Bid(item, amount);
        bids = Optional.ofNullable(bids).orElse(new ArrayList<>());
        bids.add(bid);
    }

    public List<Bid> getAllBidsForItem(final Item item) {
        return bids.stream().filter(bid -> bid.getItem().getCode().equals(item.getCode())).collect(Collectors.toList());
    }

    public Bid sellItem(Item item) {
        Bid highestBid = bids.stream()
                .filter(bid -> bid.getItem().getCode().equals(item.getCode()))
                .max(Comparator.comparing(bid -> bid.getAmount()))
                .get();
        if (highestBid.getAmount() < item.getReservePrice()) {
            throw new UnsupportedOperationException("Cannot sell item " + item.getCode() + " below the reserve price");
        }
        return highestBid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItems(List<Item> items) {
        this.items = items;
    }
}
