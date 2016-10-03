package com.so;

public class Item {

    private int reservePrice;
    private String code;
    private boolean sold;

    public Item(String code, int reservePrice) {
        this.code = code;
        this.reservePrice = reservePrice;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Item{" +
                "reservePrice=" + reservePrice +
                '}';
    }
}
