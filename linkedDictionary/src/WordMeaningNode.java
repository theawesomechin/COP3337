/*
    Author: Gavin Chin
    StudentID: 4040869
    Course: COP3337
    Professor: Smith
    Assigment5 on linkedList and some GUI.
*/
//Simple Node class
public class WordMeaningNode {
    WordMeaningNode next;
    WordMeaning word;

    public WordMeaningNode(){
        next = null;
        word = new WordMeaning("");
    }

    public WordMeaningNode(String word){
        this.word = new WordMeaning(word);
    }
}
