import java.util.ArrayList;
import java.util.LinkedList;

public class Tutorial7 {
    public static void main(String args[])
    {
        //ArrayList internally uses a dynamic array to store the elements, where we can apply a lot of modifications like
        //resizing it automatically,adding and removing items in dynamic way. LinkedList is a linear structure
        //where each element(called node) is an object with adress part and data part, and they are connected(linked) to each other
        //one by one by pointers and adresses(it uses DoublyLinkedList to store those elements).It implements both List
        //and Queque and can be used as both, while ArrayList implements just List.
        //In linkedlist its easier to insert and delete the elements, because unlikely to the ArrayList
        // we dont have to 'shift' other elements after/before such an operation, thats why the manipulation are faster then in ArrayList.
        //But on the other hand, ArrayList is faster when it comes to storing and accessing data since we can
        //access them directly because of index based system, but with LinkedList we have to travers through all elements to find one.
        //Simple implementation of both:

        LinkedList<String>  ourList = new LinkedList<String>();

        ourList.add("Anna");
        ourList.add("Barbra");
        ourList.add("Camilla");
        ourList.add("Daniela");

        System.out.println("Linked List before removing"+ourList);

        ourList.remove("Barbra");
        ourList.removeFirst();
        ourList.removeLast();

        System.out.println("Linked list after removing: " + ourList);
        ArrayList<Integer> arrlist = new ArrayList<Integer>();

        for (int i = 1; i <= 5; i++){
            arrlist.add(i);
        }
        arrlist.add(16);
        System.out.println("Array List before removing"+arrlist);
        arrlist.remove(4);
        System.out.println("Array list after removing: " +arrlist);
    }

}
