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
                        "Dictionary: shows dictionary options" +
                        "\nDeleted: Shows a list of all deprecated words from the Dictionary"
                , "Dictionary Program",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options,options[0]);


        if(response1 == 0) {
            while (true) {
                viewDictionary(newDictionary);
            }
        }
        else if(response1 == 1){
            if(newDictionary.deletedWords.size() == 0){
                int resultant = JOptionPane.showOptionDialog(null, "No Deleted Words", "Error", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(resultant == JOptionPane.OK_OPTION){viewMenu(newDictionary); }
                else{
                    viewMenu(newDictionary);
                }
            }
            for(String delWords : newDictionary.deletedWords){
                int resultD = JOptionPane.showOptionDialog(null, deletedScroll,"Deleted Words",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(resultD == JOptionPane.OK_OPTION){
                    viewMenu(newDictionary);
                }
                else{
                    System.exit(0);
                }
                //System.out.println(delWords);
            }
        }
        else if (response1 == JOptionPane.CLOSED_OPTION || response1 == JOptionPane.CANCEL_OPTION){
            System.exit(0);
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
                try {
                    String delWord = JOptionPane.showInputDialog(null, "Type the word you would like to delete");

                    while (delWord.equalsIgnoreCase("") || delWord == null) {
                        delWord = JOptionPane.showInputDialog(null, "Type the word you would like to delete");
                    }

                    newDictionary.deleteWord(delWord);
                }
                catch(NullPointerException e){
                    viewDictionary(newDictionary);
                }
                break;
            case 2:
                WordMeaningNode traverse = newDictionary.head;
                String allDictionaryWords = "";

                while(traverse != null){
                    String multiDef = "";
                    for(String defs : traverse.word.Definitions){
                        multiDef +="\t-" + defs + "\n";
                    }
                    allDictionaryWords += traverse.word.Word + "\n" + multiDef;
                    traverse = traverse.next;
                }
                JTextArea dictionaryWords = new JTextArea(allDictionaryWords);
                JScrollPane dictionaryScroll = new JScrollPane(dictionaryWords);

                int resultD = JOptionPane.showOptionDialog(null, dictionaryScroll,"Dictionary",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(resultD == JOptionPane.OK_OPTION){
                    viewDictionary(newDictionary);
                }
                else{
                    viewDictionary(newDictionary);
                }

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
