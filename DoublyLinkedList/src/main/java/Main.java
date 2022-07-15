public class Main {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addByIndex(4, 1);
        doubleLinkedList.print();

        System.out.println();
        doubleLinkedList.removeFirst();
        doubleLinkedList.removeLast();
        doubleLinkedList.removeByIndex(2);
        doubleLinkedList.print();
        System.out.println(doubleLinkedList.find(4));
    }
}
