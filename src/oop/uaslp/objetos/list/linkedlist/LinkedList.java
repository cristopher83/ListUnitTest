package oop.uaslp.objetos.list.linkedlist;

import oop.uaslp.objetos.list.listInner.Iterator;
import oop.uaslp.objetos.list.listInner.List;

public class LinkedList implements List {
    private Node head;
    private Node tail;
    private int size;

    //Methods

    //Method added by student
    public void addAtTail(String data)
    {
        Node node = new Node (data);
        if (size == 0)
        {
            head = node;
        }
        else
        {
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }
    //Method added and modify by student
    public void addAtFront(String data) {
        Node node = new Node(data);

        if (size == 0)
        {
            tail = node;
        }
        else
        {
            node.setNext(head);
            //node.getNext().setNext(head);
        }

        head = node;
        size++;
    }

    public void add(String element) {
        Node node = new Node(element);
        node.setPrevious(tail);/*El actual se lo setteo a la cola*/
        tail = node;


        if (head == null) /*Caso vacio*/ {
            head = node;
        } else {
            node.getPrevious().setNext(node); /*Basicamente obtengo el nodo anterior
        y se lo doy al nodo actual de su anterior. Y me conecta el anterior con el actual*/

        }


        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) /*Caso en que el nodo a buscar este fuera del rango*/ {
            return false;
        }
        if (size == 1) /*Caso de que sea solo un nodo*/ {
            head = null;
            tail = null;
        } else if (index == 0) /*En caso que este al inicio lo que se hace
        es tomar el siguiente y que este en la cabecera y el anterior de ese queda vacio*/ {
            head = head.next;
            head.previous = null;
        } else if (index == size - 1)/*En caso de que sea el ultimo se le asigna a la cola y el siguiente
        queda vacio o nulo*/ {
            tail = tail.previous;
            tail.next = null;
        } else{

            Node nodeIterator = findNode(index);

            nodeIterator.previous.next = nodeIterator.next;/*En esta parte
        obtengo el anterior y a este le pongo el siguiente del actual*/
            nodeIterator.next.previous = nodeIterator.previous; /*A este obtengo
        el siguiente y a este le pongo el anterior del actual que estoy eliminando*/
        }

        size--;
        return true;
    }
    //Added by student
    public void removeAll()
    {
        head = null;
        tail = null;
        size = 0;
    }
    //Added by student
    public void removeAllWithValue(String value){

    }

    private Node findNode(int index) { /*Metodo encargado de buscar un nodo*/
        Node nodeIterator=head;
        int i=0;
        while (i < index) /*Busca el nodo*/
        {
            nodeIterator=nodeIterator.getNext();/*asignacion de nodo*/
            i++;
        }
        return nodeIterator;
    }

    public boolean setAt(int index, String element)
    {
        if (index<0 || index>= size){
            return false;
        }
        Node node = findNode(index);
        node.data = element;
        return true;
    }
    public String getAt(int index)
    {
        if (index < 0)
        Node node=findNode(index);
        return node.data;
    }

    //Method added by student
    public LinkedListIterator getIterator(){
        return new LinkedListIterator();
    }

    public int getSize()
    {
        return size;
    }

    private static class Node {
        private Node next;
        private Node previous;
        private String data;

        //constructor
        public  Node(String data){
            this.data=data;
        }
        //getters y setters
        public Node getNext()
        {
            return next;
        }
        public void setNext(Node next)
        {
            this.next=next;
        }
        public Node getPrevious()
        {
            return previous;
        }
        public void setPrevious(Node previous)
        {
            this.previous= previous;
        }
        public String getData()
        {
            return data;
        }
        public void setData(String data)
        {
            this.data=data;
        }

    }
    private class LinkedListIterator implements Iterator {
        private Node current;

        //Constructor
        public LinkedListIterator(){
            this.current=head;
        }

        //Methods with implements

        public boolean hasNext() {
            return current != null;
        }


        public String next() {
            String data = current.data;
            current=current.next;
            return data;
        }
    }

}

