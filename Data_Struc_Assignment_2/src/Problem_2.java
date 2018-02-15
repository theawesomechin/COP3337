import java.util.ListIterator;

/*********************************************************************
 Purpose/Description: Create two efficient algorithms that find the difference
                      and intersection of two list.

 Author’s Panther ID: 4040869
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/
import java.util.List;

public class Problem_2 {
    public static void main(String[] args) {

    }
// This is the method to find the Different elements from L1 than in L2
    public static <AnyType extends Comparable<? super AnyType>> void difference
            (List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference)
    {
        // Initiate two element variables
        AnyType itemL1, itemL2;
        //Iterators
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        // Check to see if both Lists are populated and not empty
        if(iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        //perform the algorithm while both lists are not empty
        while(itemL1 != null && itemL2 != null){
            // use the compareTo method to check to see which item is larger
            int result = itemL1.compareTo(itemL2);
            //if both element in the lists are equal increment both list and do nothing.
            if(result == 0){
                itemL1 = iterL1.next();
                itemL2 = iterL2.next();
            }
            // it element in L1 then add this element to the difference list
            // and then iterate to the next list
            else if(result < 0){
                Difference.add(itemL1);
                itemL1 = iterL1.next();
            }
            // Finally if its not equal and L1 element is not less than L2 then increment itemL2
            else{
                itemL2 = iterL2.next();
            }
        }
        //if L2 is null then the rest of L1 is different to L2 add them to Difference List
        if(itemL1 != null && itemL2 == null){
            while(iterL1 != null){
                Difference.add(itemL1);
                itemL1 = iterL1.next();
            }
        }

    }

// A method to create a list with the Intersection of list L1 and L2
    public static <AnyType extends Comparable<? super AnyType>> void intersection
            (List<AnyType> L1, List<AnyType> L2, List<AnyType> Intersection)
    {
        // Initiate two element variables
        AnyType itemL1, itemL2;
        //Iterators
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        // if both lists are not empty then assign a variable to the first element of each list
        if(iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        // if one of the lists are empty then the intersection are empty. Finish.
        else if(iterL1 == null && iterL2 == null){
            Intersection = null;
            itemL1 = null;
            itemL2 = null;
        }
        //while both lists elements are not exhausted perform algorithm
        while(itemL1 != null && itemL2 != null)
        {
            // create a variable the stores the value of which item is larger
            int difference = itemL1.compareTo(itemL2);
            // if both elements are the same add that element to the Intersection List
            // Then increment to the next element
            if(difference == 0){
                Intersection.add(itemL1);
                itemL1 = iterL1.next();
                itemL2 = iterL2.next();
            }
            // if itemL1 is less than itemL2 then increment list1 then proceed with algorithm
            else if(difference < 0){
                itemL1 = iterL1.next();
            }
            // it itemL2 is less than itemL2 then increment list2 then proceed with algorithm
            else if(difference > 0) {
                itemL2 = iterL1.next();
            }
        }
        // if any of the Lists are exhausted to null then there are not more common elements, Finished.
    }


}
