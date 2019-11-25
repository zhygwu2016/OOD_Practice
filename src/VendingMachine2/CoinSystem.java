package VendingMachine2;

import VendingMachine1.Coin;
import VendingMachine1.Item;

import java.util.List;

/**
 * Created by FLK on 4/9/18.
 */
public class CoinSystem implements IPaymentSystem {

    private final Inventory<Coin> coinInventory;
    private final PaymentType paymentType;
    private final IVendingMachine iVendingMachine;

    public CoinSystem(final IVendingMachine iVendingMachine){
        paymentType = PaymentType.Coin;
        coinInventory = new Inventory<Coin>();
        this.iVendingMachine = iVendingMachine;
        initialize();
    }

    private void initialize(){
        for (Coin coin : Coin.values()){
            coinInventory.put(coin, 50);
        }
    }

    @Override
    public PaymentType getPaymentType() {
        return paymentType;
    }

    @Override
    public Inventory getIventory() {
        return coinInventory;
    }

    public void addPaymentValue(Coin coin) {

    }

    @Override
    public List<Coin> getRefund() {
        return null;
    }

    @Override
    public IVendingMachine getVendingMachine() {
        return iVendingMachine;
    }

    @Override
    public boolean makePayment(Item item) {
        return false;
    }
}
