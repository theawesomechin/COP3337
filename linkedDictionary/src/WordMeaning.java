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
