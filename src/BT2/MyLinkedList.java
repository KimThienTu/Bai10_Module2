package BT2;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node<E> head;
    private int numNodes;

    public MyLinkedList(){
        head = null;
        numNodes = 0;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            addFirst(element);
        else if (index == numNodes)
            addLast(element);
        else {
            Node<E> newNode = new Node<>(element);
            Node<E> prevNode = getNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            numNodes++;
        }
    }
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> lastNode = getNode(numNodes - 1);
            lastNode.next = newNode;
        }
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return removeFirst();
        else {
            Node<E> prevNode = getNode(index - 1);
            Node<E> removedNode = prevNode.next;
            prevNode.next = removedNode.next;
            numNodes--;
            return removedNode.data;
        }
    }


    public E removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        Node<E> removedNode = head;
        head = head.next;
        numNodes--;
        return removedNode.data;
    }
    public boolean remove(Object element) {
        Node<E> prevNode = null;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(element)) {
                if (prevNode == null)
                    head = currentNode.next;
                else
                    prevNode.next = currentNode.next;
                numNodes--;
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone(){
        MyLinkedList<E> newList = new MyLinkedList<>();
        Node<E> currenNode = head;
        while (currenNode != null) {
            newList.addLast(currenNode.data);
            currenNode = currenNode.next;
        }
        return newList;
    }

    public boolean contains(E element) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(element))
                return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public int indexOf(E element) {
        Node<E> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(element))
                return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes)
            throw new IndexOutOfBoundsException();

        Node<E> currentNode = getNode(index);
        if (currentNode != null) {
            return currentNode.data;
        }
        throw new IndexOutOfBoundsException();
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= numNodes)
            throw new IndexOutOfBoundsException();

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            if (currentNode == null)
                throw new IndexOutOfBoundsException();
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void printList(){
        Node<E> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}


