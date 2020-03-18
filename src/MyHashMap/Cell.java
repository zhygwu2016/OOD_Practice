package MyHashMap;

public class Cell<K, V> {
    private K key;
    private V val;
    public Cell(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey(){
        return key;
    }

    public V getVal(){
        return val;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setVal(V val) {
        this.val = val;
    }

    @Override
    public int hashCode(){
        return key == null ? 0 : key.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cell<?, ?>) {
            Cell<K, V> that = (Cell<K, V>) o; // cast 强制数据类型转换
//            return that == null
//                    ? false
//                    : this.key == null ? that.key == null : this.key.equals(that.key);
            if(this.key == null) return that.key == null;
            else return key.equals(that.key);
        } else {
            return false;
        }
    }

    public boolean keyEquals(K key){
        if(this.key == null) return key == null;
        return this.key.equals(key);
    }
}
