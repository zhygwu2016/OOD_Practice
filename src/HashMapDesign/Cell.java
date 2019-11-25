package HashMapDesign;

public class Cell<K,V> {

    private final K key;
    private V value;

    public Cell(final K key, final V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode(){
        return key.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Cell<?,? >)) return false;

        Cell<K,V> temp = (Cell<K,V>)o;

        if(key == null) return temp.key == null;
        else return key.equals(temp.key);
    }

    public boolean keyEquals(K key){
        if(this.key == null) return key == null;

        return this.key.equals(key);
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }
}
