package utils;

public class MyLinkedList <E> implements MyListInterface<E>{
    private Node head;
    private int size;
    public MyLinkedList(){
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        Node newNode=new Node();
        newNode.e=e;
        addNewNode(newNode);

    }

    @Override
    public void add(E e, int index) {
        Node newNode=new Node();
        newNode.e=e;
        insertNewNode(newNode,index);

    }

    @Override
    public E get(int index) {
        if(index>size){
            throw new IndexOutOfBoundsException("index: "+ index + " is out of bound");
        }
        Node cursor=head;
        for (int i=0 ;i<=index;i++){
            cursor=cursor.next;

        }
        return cursor.e;
    }

    @Override
    public void remove(int index) {
        removeNode(index);

    }

    @Override
    public void clear() {
        head=null;

    }

    @Override
    public int contain(E e) {
        Node cursor=head;
       for (int i=0;i<size;i++){
            if(e.equals(cursor.e)){
               return i;
            }
        }
        return -1;
    }
    private void addNewNode(Node n){
        if (size==0){
            head=n;
        }else{
            Node cursor=head;
            while (cursor.next != null){
                cursor=cursor.next;
            }
            cursor.next=n;
        }
        size++;
    }

    private void insertNewNode(Node n, int index){
        //handle the case when index too large
        if (index > size){
            throw new IndexOutOfBoundsException("index: "+ index + " is out of bound");
        }
        //
        Node cursor=head;
        for(int i = 0; i <= index; i++){
            cursor=cursor.next;

        }
        if(cursor.next==null){
            cursor.next=n;
        }else {
            Node temp = cursor.next;
            cursor.next = n;
            n.next = temp;
        }
        size++;//remember increasing the size

    }
    private void removeNode(int index){
        if(index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node cursor=head;
        for (int i = 0; i < index; i++){
            cursor=cursor.next;

        }
        if(cursor.next.next==null){
            cursor.next=null;
        }else {
            //cursor pointing to before the one  at remove
            cursor.next = cursor.next.next;
        }
       size--;
    }

    private class Node{
        Node next;//reference next reference
        E e;
    }
}
//    Object[] o = new Object[2];
//    E[] w = new E[2];
//    public E[] getArray(){
//        return (E[]) o;
//    }