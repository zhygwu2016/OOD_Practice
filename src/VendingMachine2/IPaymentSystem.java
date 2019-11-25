package VendingMachine2;

import VendingMachine1.Coin;
import VendingMachine1.Item;

import java.util.List;

/**
 * Created by FLK on 4/9/18.
 */
public interface IPaymentSystem {

    PaymentType getPaymentType();

    Inventory getIventory();

    List<Coin> getRefund();

    IVendingMachine getVendingMachine();

    boolean makePayment(Item item);

}
