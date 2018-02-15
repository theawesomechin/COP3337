/*********************************************************************
 Purpose/Description: Create methods to works with BinarySearchTree.
A method to sum each node in the tree.
A method to delete the minimum from the tree.
A method to Print in order of the tree.
A method to Print postorder of the tree.

 Author’s Panther ID: 4040869

 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 ********************************************************************/

//Unecessary class just for organization of files.
public class Problem_3 {

}

public class BinarySearchTreeNode{
    public int key;
    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;
}

public class BinarySearchTree{

    private BinarySearchTreeNode root;
    public void insert(int key){...;}
    public void delete(int key){...;}
    public void find(int key){...;}

//Method to Sum all keys in the BST
    public int keySum (){
        //calls helper method
        return keySumHelp(root);
    }
    // method takes in the node parameter
    public int keySumHelp(BinarySearchTreeNode node){
        // if the node you are on is null return
        if(node == null){
            return 0;
        }
        // else you can get the current node key and set it as the sum
        int sum = node.key;
        // if the current node is a leaf then start to return the sum
        if (node.left == null && node.right == null){
            return sum;
        }
        //else recursively call the the function for both left and right child of each node
        sum += keySumHelp(node.left);
        sum += keySumHelp(node.right);
        // return sum.
        return sum;
    }
// traverse the tree to the left until last node to get the minimum value
    public void deleteMin(){
        //since the minimum value the left most node you much check for it.
        //if the tree is not empty perform algorithm
        if(root != null) {
            //set temporary node to traverse tree
            BinarySearchTreeNode node = root;
            //traverse to the most left node until before null.
            while (node.left != null) {
                node = node.left;
            }
            // delete the last node
            delete(node.key);
        }
    }
//method to print tree inorder
    public void printTree(){
        printTreeHelp(root);
    }
//helper method for printTree()
    public void printTreeHelp(BinarySearchTreeNode node){
        //if the node is null then return
        if(node == null){
            return;
        }
        //recursive call left node
        printTreeHelp(node.left);
        //placing the println here the traversal is in order.
        System.out.println(node.key );
        //recursive call right node
        printTreeHelp(node.right);


    }
//Method to traverse the tree with a Postorder order.
    public void printPostorder(){
        printPostorderHelp(root);
    }
//Helper method for PostOrder
    public void printPostorderHelp(BinarySearchTreeNode node){
        //if the current node is null return
        if(node == null){
            return;
        }
        // recursively call left node for each node until null
        printTreeHelp(node.left);
        //recursively call right node for each node until null
        printTreeHelp(node.right);
        //Print the result of the current node
        //Since the print statement is at the end of the left and right call a post order traversal is achieved
        System.out.println(node.key );
    }
}