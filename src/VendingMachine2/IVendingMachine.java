package VendingMachine2;

import VendingMachine1.Bucket;
import VendingMachine1.Coin;
import VendingMachine1.Item;

import java.util.List;

/**
 * Created by FLK on 4/9/18.
 */
public interface IVendingMachine {
    long selectItemAndGetPrice(Item item);

    void insertCoin(Coin coin);

    List<Coin> refund();

    Bucket<Item, List<Coin>> collectItemAndChange();

    void reset();
}
