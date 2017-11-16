import javax.swing.*;
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
            while(pointer.next != null && word.compareTo(pointer.next.word.Word) < 0 ){
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

    public void insertDefinition(String word, String def){
        WordMeaningNode pointer = head;
            while(!word.equalsIgnoreCase(pointer.word.Word) && pointer.next != null){
                pointer = pointer.next;
            }
            pointer.word.addDefinition(def);
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
                    JOptionPane.showMessageDialog(null, "Word not found cannot delete", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if(deletedWords.size() == 1){
                    deletedWords.remove(0);
                    deletedWords.add("");
                    deletedWords.add(pointer.next.word.Word);
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
