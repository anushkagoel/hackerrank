package com.vending.machine;


import com.vending.machine.enums.Coin;
import com.vending.machine.enums.Item;
import com.vending.machine.service.Bucket;

import java.util.List;

public interface VendingMachine {

    public long selectItemAndGetPrice(Item item);

    public void insertCoin(Coin coin);

    public List<Coin> refund();

    public Bucket<Item, List<Coin>> collectItemAndChange();

    public void reset();
}
