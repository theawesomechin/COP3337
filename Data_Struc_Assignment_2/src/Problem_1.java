/*********************************************************************
 Purpose/Description: Create a binary search function but instead of two
                      dividing points there are three. Given the an assorted
                      array.
 Author’s Panther ID: 4040869
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.

 b) What is the running time complexity of your function?
    - The running time complexity of this function is O(log(n)) because
    each recursive call leads to a third of the previous array /subarray.
    Ultimately, reducing the time complexity to the sub-linear time.
 ********************************************************************/
public class Problem_1 {

//main method
    public static void main(String[] args){
        //initialize test array
        int[] testArr = {1,5,7,8,10,55,60};
        //get the last index of the array to be used as a param for BS method
        int lastIndex = testArr.length - 1;
        //invoke method to use the binary search
        int result = terSearch(testArr, 0, lastIndex, 8);
        //print the results
        System.out.println("Answer is index: " + result);
    }
// the recursive two divisor binary search
    public static int terSearch(int[] arr, int l, int r, int x){
        //first divisible point
        int d1 = l + (r - l) / 3;
        //second divisible point
        int d2 = d1 + (r - l) / 3;

        //checks for out of bounds
        if(r >= l) {
            // see if either divisor point is equal to int x
            if (arr[d1] == x || arr[d2] == x) {
                //returns the correct position based on ternary operator
                return arr[d1] == x ? d1 : d2;

            }
            // checks to see if the value is between the two divisors
            // if so sets the new endpoints to be between the original two
            else if (arr[d1] < x && arr[d2] > x) {

                return terSearch(arr, d1 + 1, d2 - 1, x);

            }
            //checks to see if int x is less than the lower divisor
            //if so make the new upperbound of the subarray to be d1 -1
            else if (arr[d1] > x) {

                return terSearch(arr, l, d1 - 1, x);

            }
            //checks to see if int x is larger than the upper divisor
            //if so make the new lowerbound of the subarray to be d2 + 1
            else if (arr[d2] < x) {

                return terSearch(arr, d2 + 1, r, x);

            }
        }
        // If the int x is out of bounds or doesn't exist return index as -1
        return -1;
    }
}
