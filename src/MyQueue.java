import java.util.StringJoiner;

public class MyQueue<T> {

    private int putIndex;
    private int getIndex;
    private int size;
    private Object[] items;

    private static final int DEFAULT_QUEUE_SIZE = 1024;
    public MyQueue() {
        items = new Object[DEFAULT_QUEUE_SIZE];
    }

    public MyQueue(int queueSize) {
        items = new Object[queueSize];
    }

    public int size() {
        return size;
    }

    public void clear() {
        putIndex = 0;
        getIndex = 0;
        size = 0;
        items = new Object[items.length];
    }

    public boolean add(T e) {
        if (size == items.length) {
            return false;
        }
        items[putIndex] = e;
        if (++putIndex == items.length) putIndex = 0;
        size++;
        return true;
    }

    public T peek() {
        if (size > 0) return (T) items[getIndex];
        else return null;
    }

    public T poll() {
        if (size > 0) {
            T result = (T) items[getIndex];
            items[getIndex] = null;
            if (++getIndex == items.length) getIndex = 0;
            size--;
            return result;
        } else return null;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        int index = getIndex;
        for (int i = 0; i < size ; i++) {
            result.add(((T) items[index]).toString());
            if (++index == items.length) index = 0;
        }
        return "[" + result + "]";
    }
}
