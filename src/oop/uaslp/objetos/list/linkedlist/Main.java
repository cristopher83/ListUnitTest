package oop.uaslp.objetos.list.linkedlist;

public class Main {
    public static void main(String []args){
        LinkedList list1 = new LinkedList();

        list1.add("uno");
        list1.add("dos");
        list1.add("tres");
        list1.addAtTail("ultimo");
        list1.addAtFront("primero");
        list1.remove(0);
        list1.removeAll();

    }
}
