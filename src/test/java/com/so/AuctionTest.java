package com.so;

import com.so.steps.Bids;
import com.so.steps.EvaluateBids;
import com.so.steps.Items;
import com.so.steps.SellItemIfPossible;
import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.junit.ScenarioExecutionRule;
import com.tngtech.jgiven.junit.ScenarioReportRule;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

public class AuctionTest {

    @ClassRule
    public static final ScenarioReportRule writerRule = new ScenarioReportRule();

    @Rule
    public final ScenarioExecutionRule scenarioRule = new ScenarioExecutionRule();

    @Rule
    public ItemRule itemRule = new ItemRule();

    @ScenarioStage
    Items items;

    @ScenarioStage
    Bids bids;

    @ScenarioStage
    EvaluateBids evaluateBids;

    @ScenarioStage
    SellItemIfPossible sellItemIfPossible;

    @Test
    public void an_item_is_sold() throws Exception {
        List<Item> providedItems = itemRule.getItems();
        items.given().items_are_presented_at_auction(providedItems);
        bids.given().bids_are_being_made_for_items(providedItems);
        Item goldWatch = providedItems.get(0);
        evaluateBids.when().winning_bid_is_found_for(goldWatch);
        sellItemIfPossible.then().item_is_sold();
    }

    @Test
    public void an_item_is_not_sold() throws Exception {
        List<Item> providedItems = itemRule.getItems();
        items.given().items_are_presented_at_auction(providedItems);
        bids.given().bids_are_being_made_for_items(providedItems);
        Item goldPen = providedItems.get(1);
        evaluateBids.when().winning_bid_is_found_for(goldPen);
        sellItemIfPossible.then().item_is_not_sold();
    }


}
