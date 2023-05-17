package BT2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(5);

        list.printList();

        System.out.println("Size: " + list.size());

        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Index of element 10: " + list.indexOf(10));

        System.out.println("Is element 30 present? " + list.contains(30));

        list.remove(1);
        list.printList();

        list.removeFirst();
        list.printList();
    }
}
