import utils.MyLinkedList;

public class Driver {
    public static void main(String[] args) {
    MyLinkedList<Integer> theList = new MyLinkedList<>();
        theList.add(0);
        theList.add(1);
        theList.add(2);
        theList.add(1,1);
        for (int i=0; i<theList.size();i++){
            System.out.println(theList.get(i));

        }

    }
}
