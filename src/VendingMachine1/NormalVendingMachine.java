package VendingMachine1;

import java.util.ArrayList;
import java.util.List;

import static VendingMachine1.Coin.*;

public class NormalVendingMachine implements IVendingMachine{

    private final Inventory<Coin> coinInventory;
    private final Inventory<Item> itemInventory;

    private long totalSales;
    private Item currentSelectedItem;
    private int currentBalance;

    public NormalVendingMachine(){
        coinInventory = new Inventory<Coin>();
        itemInventory = new Inventory<Item>();
        totalSales = 0;
        currentBalance = 0;

        initVendingMachine();
    }

    private void initVendingMachine(){

        for (Coin coin : Coin.values()){
            coinInventory.put(coin, 50);
        }

        for (Item item : Item.values()){
            itemInventory.put(item, 10);
        }
    }

    @Override
    public long selectItemAndGetPrice(Item item) {
        if (itemInventory.hasItem(item)){
            currentSelectedItem = item;
            return item.getPrice();
        }

        throw new SoldOutExcepton("Item Sold Out");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance += coin.getValue();
        coinInventory.add(coin);
    }

    @Override
    public List<Coin> refund() {
        final List<Coin> change = getChange(currentBalance - currentSelectedItem.getPrice());
        updateCoinInventory(change);
        reset();
        return change;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        final Item item = collectItem();
        totalSales = totalSales + currentSelectedItem.getPrice();

        List<Coin> change = collectChange();

        return new Bucket<Item, List<Coin>>(item,change);
    }

    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentSelectedItem.getPrice();
        final List<Coin> change = getChange(changeAmount);
        updateCoinInventory(change);
        reset();
        return change;
    }

    private List<Coin> getChange(long changeAmount) throws NotSufficientChangeException{
        final List<Coin> change = new ArrayList<Coin>();

        long balance = changeAmount;

        while(balance > 0){
            if(balance >= QUATER.getValue() && coinInventory.hasItem(QUATER)){
                change.add(QUATER);
                balance -= QUATER.getValue();
            } else if (balance >= DIME.getValue() && coinInventory.hasItem(DIME)) {
                change.add(DIME);
                balance -= DIME.getValue();
            } else if (balance >= NICKLE.getValue() && coinInventory.hasItem(NICKLE)) {
                change.add(NICKLE);
                balance -= NICKLE.getValue();
            } else if (balance >= PENNY.getValue() && coinInventory.hasItem(PENNY)) {
                change.add(PENNY);
                balance -= PENNY.getValue();
            } else {
                throw new NotSufficientChangeException("No Sufficent Amount of Change");
            }
        }

        return change;
    }

    private void updateCoinInventory(List<Coin> change){
        for (Coin coin : change){
            coinInventory.deduct(coin);
        }
    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException {
        if(isFullPaid()){
            if(hasSufficientChange()){
                itemInventory.deduct(currentSelectedItem);
                return currentSelectedItem;
            }

            throw new NotSufficientChangeException("Not Sufficent Change is in the inventory");
        }

        final long remainingBalance = currentSelectedItem.getPrice() - currentBalance;

        throw new NotFullPaidException("Please pay the remaining amount", remainingBalance);
    }

    private boolean isFullPaid() {

        return currentBalance >= currentSelectedItem.getPrice();
    }

    private boolean hasSufficientChange(){
        return checkChange(currentBalance - currentSelectedItem.getPrice());
    }

    private boolean checkChange(long amount){
        try{
            getChange(amount);
        } catch (NotSufficientChangeException e) {
            return false;
        }

        return true;
    }

    @Override
    public void reset() {
        currentSelectedItem = null;
        currentBalance = 0;
    }
}
