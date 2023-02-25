

import java.util.StringJoiner;



public class MyLinkedList<T> {
    int size = 0;
    Node<T> first;
    Node<T> last;

    public MyLinkedList() {
    }

    public void add(T e) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Node<T> x = first;
        while (x != null) {
            Node<T> next = x.next;
            x.prev = null;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return node(index).item;
        } else {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public T remove(int index) {
        if (index >= 0 && index <= size) {
            Node<T> x = node(index);
            T element = x.item;
            Node<T> prev = x.prev;
            Node<T> next = x.next;
            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                x.prev = null;
            }
            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                x.next = null;
            }
            x.item = null;
            size--;
            return element;
        } else {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        Node<T> x = first;
        while (x != null) {
            result.add(x.item.toString());
            x = x.next;
        }
        return "[" + result + "]";
    }

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

}
