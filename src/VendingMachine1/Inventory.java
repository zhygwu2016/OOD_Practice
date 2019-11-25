package VendingMachine1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FLK on 4/8/18.
 */
public class Inventory<T> {

    private Map<T, Integer> inventory = new HashMap<T, Integer>();

    public int getQuantity(T item){
        final Integer num = inventory.get(item);
        return num == null ? 0 : num;
    }

    public void add(T item){
        Integer count = inventory.get(item);

        count = (count == null) ? 0 : count;

        inventory.put(item,count + 1);
    }

    public void deduct(T item){
        if(hasItem(item)){
            inventory.put(item,inventory.get(item) - 1);
        }
    }

    public boolean hasItem(T item){
        return getQuantity(item) > 0;
    }

    public void clear(){
        inventory.clear();
    }

    public void put(T item, int num){
        inventory.put(item,getQuantity(item) + num);
    }
}
