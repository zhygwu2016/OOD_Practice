package VendingMachine2;

import VendingMachine1.Coin;
import VendingMachine1.Item;

import java.util.List;

/**
 * Created by FLK on 4/9/18.
 */
public class CreditCardSystem implements IPaymentSystem {
    @Override
    public PaymentType getPaymentType() {
        return null;
    }

    @Override
    public Inventory getIventory() {
        return null;
    }

    public void addPaymentValue() {

    }

    @Override
    public List<Coin> getRefund() {
        return null;
    }

    @Override
    public IVendingMachine getVendingMachine() {
        return null;
    }

    @Override
    public boolean makePayment(Item item) {
        return false;
    }
}
