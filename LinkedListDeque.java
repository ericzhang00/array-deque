public class LinkedListDeque<T> implements Deque<T> {
    private class DLL {
        DLL prev;
        T item;
        DLL next;
        DLL(DLL x, T y, DLL z) {
            prev = x;
            item = y;
            next = z;
        }
    }
    private int size = 0;

    private DLL sentinel = new DLL(null, null, null);

    @Override
    public void addFirst(T item) {
        if (size == 0) {
            DLL newFirst = new DLL(sentinel, item, sentinel);
            sentinel.prev = newFirst;
            sentinel.next = newFirst;
        } else {
            DLL newFirst = new DLL(sentinel, item, sentinel.next);
            sentinel.next.prev = newFirst;
            sentinel.next = newFirst;
        }
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            DLL newLast = new DLL(sentinel, item, sentinel);
            sentinel.prev = newLast;
            sentinel.next = newLast;
        } else {
            DLL newLast = new DLL(sentinel.prev, item, sentinel);
            sentinel.prev.next = newLast;
            sentinel.prev = newLast;
        }
        size = size + 1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (!this.isEmpty()) {
            DLL current = sentinel.next;
            while (current != sentinel) {
                System.out.print(current.item + " ");
                current = current.next;
            }
            System.out.println(" ");
        }
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        size = size - 1;
        T first = sentinel.next.item;
        if (size == 0) {
            sentinel.prev = null;
            sentinel.next = null;
        } else {
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
        }
        return first;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        size = size - 1;
        T last = sentinel.prev.item;
        if (size == 0) {
            sentinel.prev = null;
            sentinel.next = null;
        } else {
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
        }
        return last;
    }

    @Override
    public T get(int index) {
        if ((index < 0) || (index >= size)) {
            return null;
        }
        DLL current = sentinel.next;
        int i = 0;
        while (i < index) {
            current = current.next;
            i = i + 1;
        }
        return current.item;
    }

    public LinkedListDeque() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new DLL(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        int index = 0;
        DLL current = other.sentinel.next;
        while (index < other.size) {
            addLast(current.item);
            index = index + 1;
            current = current.next;
        }
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(DLL curr, int index) {
        if ((index < 0) || (index >= size)) {
            return null;
        }
        if (index == 0) {
            return curr.item;
        }
        return getRecursiveHelper(curr.next, index - 1);
    }
}
