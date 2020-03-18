package MyHashMap;

public class MyMap<K, V> {
    private Bucket<K, V>[] buckets;
    private int bucketSize;
    private static final double LOAD_FACTOR = 0.75d;
    private int curSize = 0;

    public MyMap(){
        this.bucketSize = 256;
        this.buckets = new Bucket[this.bucketSize];
    }

    private int hashFunction(K key) {
        return key == null
                ? 0
                : key.hashCode() % this.bucketSize;
    }

    public V get(K key) {
        int idx = hashFunction(key);
        if (buckets[idx] == null) return null;
        return this.buckets[idx].get(key);
    }

    public void put(K key, V val) {
        int idx = hashFunction(key);
        if (buckets[idx] == null) buckets[idx] = new Bucket<K, V>();
        if (buckets[idx].put(key, val)) this.curSize++;
        if (this.curSize >= this.bucketSize * LOAD_FACTOR) rehashing();
    }

    public boolean remove(K key) {
        Bucket<K, V> b = buckets[hashFunction(key)];
        if (b == null) return false;
        return b.remove(key);
    }

    private void rehashing(){
        this.bucketSize *= 2;
        Bucket<K, V>[] newBuckets = new Bucket[this.bucketSize];
        for (Bucket<K, V> bucket : this.buckets) {
            for (Cell<K, V> cell : bucket.cells) {
                int idx = hashFunction(cell.getKey());
                if (newBuckets[idx] == null) {
                    newBuckets[idx] = new Bucket<K, V>();
                }
                newBuckets[idx].put(cell.getKey(), cell.getVal());
            }
        }
        this.buckets = newBuckets; // Java garbage collector
    }
}
