public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = 4;
        last = 3;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.size);
        first = other.first;
        last = other.last;
        size = other.size;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (first < last) {
            System.arraycopy(items, first, a, 0, last - first + 1);
        } else {
            System.arraycopy(items, first, a, 0, items.length - first);
            System.arraycopy(items, 0, a, items.length - first, last + 1);
        }
        first = 0;
        last = size - 1;
        items = a;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        if (first == 0) {
            first = items.length - 1;
        } else {
            first = first - 1;
        }
        size = size + 1;
        items[first] = item;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        if (last == items.length - 1) {
            last = 0;
        } else {
            last = last + 1;
        }
        size = size + 1;
        items[last] = item;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T front = items[first];
        items[first] = null;
        if (first < items.length - 1) {
            first = first + 1;
        } else {
            first = 0;
        }
        size = size - 1;
        if (size < (items.length / 4) && items.length > 16) {
            resize(items.length / 2);
        }
        return front;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T back = items[last];
        items[last] = null;
        if (last > 0) {
            last = last - 1;
        } else {
            last = items.length - 1;
        }
        size = size - 1;
        if (size < (items.length / 4) && items.length > 16) {
            resize(items.length / 2);
        }
        return back;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index < (items.length - first)) {
            return items[first + index];
        }
        return items[index - (items.length - first)];
    }

    @Override
    public void printDeque() {
        int current = first;
        if (last < first) {
            while (current < items.length) {
                System.out.print(items[current] + " ");
                current = current + 1;
            }
            current = 0;
        }
        while (current < last) {
            System.out.print(items[current] + " ");
            current = current + 1;
        }
        System.out.println(" ");
    }
}
