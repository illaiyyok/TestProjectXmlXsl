package bharath;

import java.util.Iterator;

public class Arrlist implements MyList {
    Object[] obj = new Object[5]; // super class top most level
    int size = 0;
    // private java.lang.Object[] array;


    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {

    }

    @Override
    public void add(Object value) {
        if (size >= obj.length) {
            Object[] temp = new Object[2 * size];
            for (int i = 0; i <= obj.length - 1; i++) {
                temp[i] = obj[i];
            }
            obj = temp;
            obj[size++] = value;
        } else {
            obj[size++] = value;
        }
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        Object value = obj[index];
        int copyfromindex = index+1;
       
        if(copyfromindex < size){
            System.arraycopy(obj,copyfromindex,obj,index,size- copyfromindex);
        }
        obj[--size] = null;
        return value;
    }

    @Override
    public boolean delete(Object value) {

        return false;
    }

    @Override
    public void clear() {

        obj = new Object[5];
        size = 0;

    }

    @Override
    public Object set(int index, Object value) throws IndexOutOfBoundsException {

            Object oldvalue = obj[index];
            obj[index] = value;
            return oldvalue;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return obj[index];
    }


    @Override
    public int indexOf(Object value) {
        if(value!= null){

            for(int i=0;i<size;++i){
                if(value.equals(obj[i])){
                    return i;
                }
            }

        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {

        return indexOf(value) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public Iterator iterator() {

        return null;
    }


}
