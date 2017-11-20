/*
    Author: Gavin Chin
    StudentID: 4040869
    Course: COP3337
    Professor: Smith
    Assigment5 on linkedList and some GUI.
*/
//WordMeaning class that calls WordMeaning objects.
import java.util.ArrayList;

public class WordMeaning{

    String Word;
    ArrayList<String> Definitions = new ArrayList<>();

    public WordMeaning(String title){
        Word = title;
    }

    public void addDefinition(String def){
        Definitions.add(def);
    }


}
