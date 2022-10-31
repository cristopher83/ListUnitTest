package oop.uaslp.objetos.list.listInner;

public interface List {
    //Methods
    void addAtTail(String data);

    //Metodo encargado de agregar al inicio los datos
    void addAtFront(String data);
    //Metodo encargado de eliminar un espacio
    boolean remove(int indexToRemove);
    void removeAll();
    boolean setAt(int index, String data);
    String getAt(int index);
    void removeAllWithValue(String value);
    int getSize();
    Iterator getIterator();
}
