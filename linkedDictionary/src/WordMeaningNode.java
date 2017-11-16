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
