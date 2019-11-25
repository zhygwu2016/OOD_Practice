package VendingMachine2;

import VendingMachine1.Bucket;
import VendingMachine1.Coin;
import VendingMachine1.Item;

import java.util.List;

/**
 * Created by FLK on 4/9/18.
 */
public class MultiPaymentVendingMachine implements IVendingMachine {

    private long totalSales;
    private Item currentSelectedItem;
    private int currentBalance;



    @Override
    public long selectItemAndGetPrice(Item item) {
        return 0;
    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public List<Coin> refund() {
        return null;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        return null;
    }

    @Override
    public void reset() {

    }
}
