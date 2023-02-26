import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMap<K,V> {
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    Node<K,V> table;
    int trashHold;

   // (n - 1) & hash

   // 128 64 32 16 8 4 2 1
    // 00001101 (length - 1) = 13
    // 01001001 hash
    // 00001001 = 9

    static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        @Override
        public final String toString() { return key + "=" + value; }
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


