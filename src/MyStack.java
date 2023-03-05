import java.util.StringJoiner;

public class MyStack<T> {

    private static final int DEFAULT_STACK_SIZE = 1024;
    private int index = -1;

    private Object[] stackData;

    public MyStack() {
        this(DEFAULT_STACK_SIZE);
    }

    public MyStack(int stackSize) {
        stackData = new Object[stackSize];
    }

    public boolean push(T value) {
        if (index == stackData.length - 1) return false;
        stackData[++index] = value;
        return true;
    }

    public T peek() {
        if (index < 0) return null;
        return (T) stackData[index];
    }

    public T pop() {
        if (index < 0) return null;
        return (T) stackData[index--];

    }

    public int size() {
        return index + 1;
    }

    public void clear() {
        index = -1;
        stackData = new Object[stackData.length];
    }

    public T remove(int ind) {
        if (ind < 0 || ind > index) return null;
        T result = (T) stackData[ind];
        for (int i = ind; i < index; i++) {
            stackData[i] = stackData[i + 1];
        }
        index--;
        return result;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i <= index ; i++) {
            result.add(((T) stackData[i]).toString());
        }
        return "[" + result + "]";
    }
}
