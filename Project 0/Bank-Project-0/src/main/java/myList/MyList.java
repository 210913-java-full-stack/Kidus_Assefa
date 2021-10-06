package myList;

import java.util.Arrays;

public class MyList<T> implements MyArrayListInterface<T>{
    public int size;
    public  int maxSize;
    public Object myArraylist[];
    private int arrayElement;

    /**
     * initialize the size of the array to zero and put the maximum value to 2 for now and assigning the array list
     * with a new object array of maxSize
     */
    public MyList()
    {
        size=0;
        maxSize=2;
        myArraylist = new Object[maxSize];
        this.arrayElement=0;
    }

    /**
     * growing up the array size by 2
     */
    private void growMyArray()
    {
        //growing up my array
        int newArraySize = myArraylist.length * 2;
        myArraylist = Arrays.copyOf(myArraylist, newArraySize);
    }


    /**
     * this returns the size of the array
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * if the size of the array is greater than the length of the array  then it will call the graw array and increase
     * the size of array and assign it the object
     * @param t
     */
    @Override
    public void add(T t) {
        if(size >= myArraylist.length)
        {

            growMyArray();
        }

        myArraylist[size++] = t;
    }

    @Override
    public void add(T t, int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if((size+1) >= myArraylist.length)
        {
            growMyArray();
        }
        for(int i = size;i >= index;i--)
        {
            myArraylist[i+1] = myArraylist[i];
        }


        myArraylist[index] = t;
        size++;

    }

    @Override
    public T get(int index) {
        return (T) myArraylist[index];
    }

    @Override
    public void remove(int index) {
        for(int i=index;i<size;i++)
        {
            myArraylist[i] = myArraylist[i+1];
        }
        size--;

    }

    /**
     * clear the array and make the size to 0
     */
    @Override
    public void clear() {
        Object newArray[] = new Object[size];
        myArraylist = Arrays.copyOf(newArray, size);
        size = 0;

    }

    /**
     * checking the array is contained a value in the array , and if the array holds that value it will return
     * if not contained it will return -1
     * @param t
     * @return
     */
    @Override
    public int contains(T t) {
        for(int i=0;i<size;i++)
        {
            if(myArraylist[i] == t)
            {
                return i;
            }
            else return -1;
        }

        return -1;
    }
    public int getArrayElement(){
        return arrayElement;
    }

}
