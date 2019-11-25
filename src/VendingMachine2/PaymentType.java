package VendingMachine2;

/**
 * Created by FLK on 4/9/18.
 */
public enum PaymentType {

    Coin("Coin"),

    Cash("Cash"),

    CreditCard("CreditCard");

    private String paymentType;

    PaymentType(final String paymentType){
        this.paymentType = paymentType;
    }

    public String toString(){
        return paymentType;
    }
}
