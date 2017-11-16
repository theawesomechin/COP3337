import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;

public class WordList {

    WordMeaningNode head;
    ArrayList<String> deletedWords = new ArrayList<>();
    public WordList(String s){
        head = new WordMeaningNode(s);
        deletedWords.add("No Words in the List");
    }

    public void insertWord(String word){
        WordMeaningNode wordNode = new WordMeaningNode(word);
        WordMeaningNode pointer = head;
        if(word.compareTo(head.word.Word) < 0){
            wordNode.next = head;
            head = wordNode;
        }
        else{
            while(word.compareTo(pointer.next.word.Word) < 0 && pointer.next != null){
                pointer = pointer.next;
            }
            wordNode.next = pointer.next;
            pointer.next = wordNode;
        }

    }

    public void deleteWord(String word){
        WordMeaningNode pointer = head;
        if(pointer.word.Word.equalsIgnoreCase(word)){
            head = head.next;
        }
        else{
            try {
                while (!pointer.next.word.Word.equalsIgnoreCase(word) && pointer.next != null) {
                    pointer = pointer.next;
                }
                if (pointer.next == null) {
                    System.out.println("word not found");
                }
                deletedWords.add(pointer.next.word.Word);
                pointer.next = pointer.next.next;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
