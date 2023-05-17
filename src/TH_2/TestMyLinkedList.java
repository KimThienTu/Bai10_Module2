package TH_2;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList list = new MyLinkedList(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);

        list.add(4,9);
        list.add(4,9);
        list.printList();

    }
}

