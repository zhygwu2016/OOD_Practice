package HashMapDesign;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap<K,V> {

    private static final double LOAD_FACTOR = 0.75d;

    private static int MAX_SIZE = 512;

    private List<Cell<K,V>>[] cells;

    private int size;

    public MyHashMap(){
        cells = (List<Cell<K,V>>[])new ArrayList[MAX_SIZE];
        this.size = 0;
    }

    public int keyHashCode(K key){
        if (key == null) return 0;
        return key.hashCode() % MAX_SIZE;
    }

    public void put(K key, V value){
        final Cell<K,V> cell = new Cell<K,V>(key,value);

        final int index = keyHashCode(key);

        if(cells[index] == null){
            cells[index] = new ArrayList<Cell<K,V>>();
        }

        List<Cell<K,V>> slot = cells[index];

        for(Cell<K,V> temp : slot){
            if(cell.equals(temp)){
                slot.remove(temp);
                size--;
                break;
            }
        }

        slot.add(cell);
        size++;

        if(size > MAX_SIZE * LOAD_FACTOR){
            reHashing();
        }
    }

    public V get(K key){
        final int index = keyHashCode(key);

        List<Cell<K,V>> slot = cells[index];

        if(slot == null) return null;

        for(Cell<K,V> cell : slot){
            if(cell.keyEquals(key)) return cell.getValue();
        }

        return null;
    }

    private void reHashing(){
        MAX_SIZE *= 2;

        List<Cell<K,V>>[] newCells = (List<Cell<K,V>>[])new ArrayList[MAX_SIZE];

        for(List<Cell<K,V>> slot : cells){
            if(slot != null){
                for(Cell<K,V> cell : slot){
                    final int index = keyHashCode(cell.getKey());
                    if(newCells[index] == null) newCells[index] = new ArrayList<Cell<K,V>>();
                    newCells[index].add(cell);
                }

            }
        }

        cells = newCells;
    }
}
