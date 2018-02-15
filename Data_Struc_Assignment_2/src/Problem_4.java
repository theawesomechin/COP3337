import java.util.LinkedList;
/*********************************************************************
 Purpose/Description: Implement a LinkedList and implements three methods
 a push method to add to the front of the list. A pop method to remove the first
 item of the list and return it. Finally inject an object to the last position
 in a LinkedList all in O(1) time complexity.

 Author’s Panther ID: 4040869

 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/
public class Problem_4 {
}
//extend the LinkedList class
public class MyList <AnyType> extends LinkedList{

    MyList newList;
//Constructor of MyList
    MyList() {
        this.newList = new MyList();
    }
//Push an object to the front of the list
    void myPush(AnyType x) {
        this.newList.addFirst(x);
    }
//Pop and return the first item of the list
    AnyType myPop() {
        return (AnyType) this.newList.removeFirst();
    }
//Insert and item at the end of the list
    void myInject(AnyType x) {
        this.newList.addLast(x);
    }
}