import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMap<K, V> {
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    Node<K, V>[] table;

    public MyHashMap(int initialCapacity) {
        table = (Node<K, V>[]) new Node[initialCapacity];
    }

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    private static final int hash(Object key) {
        int h;
//        h = key.hashCode();
//        h = h ^ (h >>> 16);
//        if (key == null) h = 0;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        Node<K, V> p;
        int i;
        int hash = hash(key);
        i = (table.length - 1) & hash;
        p = table[i];
        if (p == null) {
            p = new Node<K, V>(hash, key, value, null);
            table[i] = p;
            size++;
            return null;
        } else {
            Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || key != null && key.equals(k))) {
                V oldValue = p.value;
                p.value = value;
                return oldValue;
            } else {
                do {
                    e = p.next;
                    if (e == null) {
                        e = new Node<K, V>(hash, key, value, null);
                        p.next = e;
                        size++;
                        return null;
                    } else {
                        if (e.hash == hash && ((k = e.key) == key || key != null && key.equals(k))) {
                            V oldValue = e.value;
                            e.value = value;
                            return oldValue;
                        }
                        p = e;
                    }
                } while (true);
            }
        }
    }

    public V get(K key) {
        return getElement(key, false);
    }

    public V remove(K key) {
        return getElement(key, true);
    }

    private V getElement(K key, boolean remove) {
        int hash = hash(key);
        int i = (table.length - 1) & hash;
        Node<K,V> p = table[i];
        if (p == null) return null;
        K k;
        V v;
        if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
            v = p.getValue();
            if (remove) {
                if (p.next != null) {
                    table[i] = p.next;
                } else table[i] = null;
                p.value = null;
                p.next = null;
                p = null;
                size--;
            }
            return v;
        }
        Node<K,V> e;
        while((e = p.next) != null) {
            if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                v = e.getValue();
                if (remove) {
                    if (e.next != null) {
                        p.next = e.next;
                    } else p.next = null;
                    e.value = null;
                    e.next = null;
                    e = null;
                    size--;
                }
                return v;
            }
        }
        return null;
    }

    public void clear() {
        Node<K,V> p, e;
        for (int i = 0; i < table.length; i++) {
            p = table[i];
            if (p != null) {
               do {
                   e = p.next;
                   p.value = null;
                   p.next = null;
                   p = e;
               } while (e != null);
            }
        }
        size = 0;
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Node<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }


}


