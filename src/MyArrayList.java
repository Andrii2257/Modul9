import java.util.Arrays;
import java.util.StringJoiner;

public class MyArrayList<T> {
    private int index = -1;
    private Object[] arrayData;
    private static final int DEFAULT_ARRAY_SIZE = 16;

    public MyArrayList() {
        this(DEFAULT_ARRAY_SIZE);
    }

    public MyArrayList(int size) {
        if (size <= 0) {
            arrayData = new Object[DEFAULT_ARRAY_SIZE];
        }
        arrayData = new Object[size];
    }

    public int size() {
        return index + 1;
    }

    public void add(T value) {
        resizeIfNeed();
        index++;
        arrayData[index] = value;
    }

    private void resizeIfNeed() {
        if (index == arrayData.length - 1) {
            int newLength = arrayData.length + (arrayData.length >> 1);
            Object[] newArray = Arrays.copyOf(arrayData, newLength);
            arrayData = newArray;
        }
    }

    public T get(int ind) {
        if (ind >= 0 && ind <= index) {
            return (T) arrayData[ind];
        }
        return null;
    }

    public void clear() {
        arrayData = new Object[DEFAULT_ARRAY_SIZE];
        index = -1;
    }

    public T remove(int ind) {
        if (ind < 0 || ind > index) return null;
        T result = (T) arrayData[ind];
        for (int i = 5; i < index; i++) {
            arrayData[i] = arrayData[i + 1];
        }
        index--;
        return result;
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i <= index; i++) {
            result.add(arrayData[i].toString());
        }
        return "[" + result + "]";
    }
}

