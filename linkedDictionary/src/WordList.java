/*
    Author: Gavin Chin
    StudentID: 4040869
    Course: COP3337
    Professor: Smith
    Assigment5 on linkedList and some GUI.
*/
/* This is the linkedlist class takes in the node class to do several
   operations to the linkedlist: delete a node and insert a node
*/
import javax.swing.*;
import java.util.ArrayList;

public class WordList {
    //delcare an pointer at the start of the linked list as head this is what will be returned at the end.
    WordMeaningNode head;
    //using Array list to store the deletedWords because I don't want to make another linked list for deleted words.
    ArrayList<String> deletedWords = new ArrayList<>();
    public WordList(String s){
        head = new WordMeaningNode(s);
    }

    //Inserts a node to the linked list using only two pointers
    public void insertWord(String word){
        WordMeaningNode wordNode = new WordMeaningNode(word);
        WordMeaningNode pointer = head;
        if(head == null){
            head = wordNode;
        }
        else if(word.equalsIgnoreCase(pointer.word.Word) ){

        }
        else if(word.compareTo(head.word.Word) < 0){
            wordNode.next = head;
            head = wordNode;
        }
        else{
            boolean resume = false;
            while(pointer.next != null && word.compareTo(pointer.next.word.Word) >= 0 ){
                pointer = pointer.next;
                if(word.equalsIgnoreCase(pointer.word.Word)){
                    resume = true;
                }
            }
            if(!resume) {
                wordNode.next = pointer.next;
                pointer.next = wordNode;
            }
        }

    }
    // inserts a definition corresponding to a WordMeaning datatype node. Definitions are stored also in an Array list
    public void insertDefinition(String word, String def){
        WordMeaningNode pointer = head;
            while(!word.equalsIgnoreCase(pointer.word.Word) && pointer.next != null){
                pointer = pointer.next;
            }
            pointer.word.addDefinition(def);
    }
    // traverse the linkedlist to find its position ane delete that node while keeping the integrity of the linkedlist.
    public void deleteWord(String word){
        WordMeaningNode pointer = head;
        if(pointer.word.Word.equalsIgnoreCase(word)){
            head = head.next;
            deletedWords.add(word);
            System.out.println(deletedWords);
        }
        else{
            try {
                while (pointer.next != null && !pointer.next.word.Word.equalsIgnoreCase(word)) {
                    pointer = pointer.next;
                }
                if (pointer.next == null) {
                    JOptionPane.showMessageDialog(null, "Word not found cannot delete", "Error", JOptionPane.ERROR_MESSAGE);
                }
                deletedWords.add(word);
                System.out.println(deletedWords.toString());
                pointer.next = pointer.next.next;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
