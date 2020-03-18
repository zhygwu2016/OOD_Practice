package MyHashMap;

import java.util.ArrayList;
import java.util.List;

public class Bucket<K, V> {
    protected List<Cell<K, V>> cells;
    public Bucket(){
        this.cells = new ArrayList<>(); // easily swap for remove()
    }

    public V get(K key) {
        for (Cell<K, V> cell : this.cells) {
            if (cell.keyEquals(key)) {
                return cell.getVal();
            }
        }
        return null;
    }

    public boolean put(K key, V val){
        Cell<K, V> insertMe = new Cell<K, V>(key, val);
        for (Cell<K, V> cell : this.cells) {
            if (cell.keyEquals(key)) {
                cell.setVal(val);
                return false;
            }
        }
        // insert
        this.cells.add(insertMe);
        return true;
    }

    public boolean remove (K key) {
        boolean isContained = false;
        for (Cell<K, V> cell : this.cells) {
            if (cell.keyEquals(key)) {
                Cell<K, V> lastCell = this.cells.get(this.cells.size() - 1);
                cell.setKey(lastCell.getKey());
                cell.setVal(lastCell.getVal());
                isContained = true;
                break;
            }
        }
        if (isContained) {
            this.cells.remove(this.cells.size() - 1);
        }
        return isContained;
    }
}
