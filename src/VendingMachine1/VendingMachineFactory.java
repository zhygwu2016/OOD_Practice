package VendingMachine1;

/**
 * Created by FLK on 4/8/18.
 */
public class VendingMachineFactory {
    public static NormalVendingMachine createVendingMachine(){
        return new NormalVendingMachine();
    }
}
