package BT1;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList(){
        this.size = 0;
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid capacity: " + capacity);
        }
        this.size = 0;
        this.elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index +1, size - index);
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        E removeElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removeElement;
    }

    public int size(){
        return size;
    }

    public MyList<E> clone() {
        MyList<E> cloneList = new MyList<>(size);
        cloneList.size = size;
        cloneList.elements = Arrays.copyOf(elements, size);
        return cloneList;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length){
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (E) elements[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }
}
