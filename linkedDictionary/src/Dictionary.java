import javax.swing.*;

public class Dictionary {
    public static void main(String[] args){

        WordList newDictionary = new WordList("school");
        newDictionary.head.word.addDefinition("An Educational Facility.");
        viewMenu(newDictionary);
    }
    public static void viewMenu(WordList newDictionary){
        String allDeletedWords = "";
        for(String words : newDictionary.deletedWords){
            //System.out.println(words);
            allDeletedWords += words + "\n";
        }
        JTextArea deletedWordsList = new JTextArea(allDeletedWords);
        JScrollPane deletedScroll = new JScrollPane(deletedWordsList);

        String[] options = {"Dictionary","Deleted","Cancel"};
        int response1 = JOptionPane.showOptionDialog(null, "Welcome to the Dictionary App\n\n" +
                        "Dictionary: Shows in a scrollable window all the Words and there definitions" +
                        "\nDeleted: Shows a list of all deleted words from the Dictionary"
                , "Dictionary Program",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options,options[0]);


        if(response1 == 0) {
            while (true) {
                viewDictionary(newDictionary);
            }
        }
        else if(response1 == 1){
            for(String delWords : newDictionary.deletedWords){
                //int option = JOptionPane.OK_CANCEL_OPTION;
                int resultD = JOptionPane.showOptionDialog(null, deletedScroll,"Deleted Words", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(resultD == JOptionPane.OK_OPTION){
                    viewMenu(newDictionary);
                }
                else{
                    System.exit(0);
                }
                System.out.println(delWords);
            }
        }
    }

    public static void viewDictionary(WordList newDictionary){
        String[] options2 = {"Add Word", "Delete Word", "View Dictionary", "Go Back"};
        int response2 = JOptionPane.showOptionDialog(null, "Choose an Option",
                "Edit/View Dictionary",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options2,options2[0]);
        switch(response2){
            case 0:
                try {
                    String addWord = JOptionPane.showInputDialog(null, "Type the word you would like to add:");
                    addWord.toLowerCase();
                    if (!addWord.equalsIgnoreCase("") && addWord != null) {
                        newDictionary.insertWord(addWord);
                        String addDef = JOptionPane.showInputDialog(null, "Type the definition you would like to add to " + addWord);
                        addDef.toLowerCase();
                        while(addDef.equalsIgnoreCase("") || addDef == null) {
                            addDef = JOptionPane.showInputDialog(null, "Type the definition you would like to add to " + addWord);
                        }
                        newDictionary.insertDefinition(addWord, addDef);
                    }
                    else{
                        throw new RuntimeException("Cannot be empty input");
                    }
                }
                catch(RuntimeException e){
                    JOptionPane.showMessageDialog(null, "Empty Input Option Found", "Blasphemous Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 1:
                String delWord = JOptionPane.showInputDialog(null, "Type the word you would like to delete");

                while(delWord.equalsIgnoreCase("") || delWord == null) {
                    delWord = JOptionPane.showInputDialog(null, "Type the word you would like to delete");
                }
                newDictionary.deleteWord(delWord);
                break;
            case 2:
                WordMeaningNode pointer = newDictionary.head;
                System.out.println("---------------");
                while(pointer != null){
                    System.out.println(pointer.word.Word) ;
                    for(String defs : pointer.word.Definitions){
                        System.out.println("\t-" + defs);
                    }
                    pointer = pointer.next;
                }
                System.out.println("---------------");
                break;
            case 3:
                viewMenu(newDictionary);
                break;
            case JOptionPane.CLOSED_OPTION:
                System.exit(0);
                break;
        }
    }
}
