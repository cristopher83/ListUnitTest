package oop.uaslp.objetos.list.arraylist;
import oop.uaslp.objetos.list.listInner.*;

public class ArrayList implements List{
    private String []data;
    private int size;

    //Constructor with length 2
    public ArrayList() {

        data = new String[2];
    }

    //Methods
    public void addAtTail(String data){
        if(size == this.data.length){ //Verifica que exista espacio de ser asi contiua sino lo duplica
            increaseArraySize();
        }
        this.data[size]=data; // lo agrega en el lugar correspondiente y aumenta 1
        size++;
    }

    //Este se encarga de crear un arreglo mas grande y a su vez pasar los datos
    public void increaseArraySize()
    {
        String[] newArray = new String[this.data.length*2]; // Instancia el arreglo con el doble de tamaño

        for (int i=0; i<data.length;i++){
            newArray[i]= data[i];
        }
        data=newArray;

    }
    //Metodo encargado de agregar al inicio los datos
    public void addAtFront(String data){
        if (size==this.data.length){ //Verifica que halla espacio aun en el arreglo
            increaseArraySize();
        }
        for (int i=getSize();i > 0;i--){  //Recorre todos los datos un espacio para darle el lugar al que se va a insertar
            this.data[i]=this.data[i-1];
        }
        this.data[0]=data;
        size++;
    }

    //Metodo encargado de eliminar un espacio
    public boolean remove(int indexToRemove){
        if (indexToRemove<0 || indexToRemove>= size){ //Verifica que el indice a eliminar este correcto ya su vez no sea mayor que el tam del arreglo
            return false; //termina el proceso retornando falso si entra aqui
        }
        for (int i=0; i<indexToRemove;i++){
            data[i]=data[i+1];
        }
        data[size]=null;
        size--;
        return true;
    }

    public void removeAll(){
        for (int i=0; i<size;i++){
            data[i]=null;
        }
        size=0;
    }

    public boolean setAt(int index, String data){
        if (index<0 || index>= size){
            return false;
        }
        this.data[index]=data;
        return true;
    }

    public String getAt(int index){
        if (index<0 || index>= size){
            return null;
        }
        return this.data[index];
    }

    public void removeAllWithValue(String value){
        String[]newArray = new String[data.length];
        int cout=0;
        for(int i=0; i< size;i++){
            if (!data[i].equals(value)){
                newArray[cout]=data[i];
                cout++;
            }
        }
        this.data=newArray;
        size=cout;
    }
    public int getSize()
    {
        return size;
    }

    public ArrayListIterator getIterator(){
        return new ArrayListIterator(this);
    }
}
