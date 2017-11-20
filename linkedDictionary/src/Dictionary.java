/*
    Author: Gavin Chin
    StudentID: 4040869
    Course: COP3337
    Professor: Smith
    Assigment5 on linkedList and some GUI.
*/
import javax.swing.*;

public class Dictionary {
    /* Main method stores a linkedlist called newDictionary
    and sets a default word and definition in the dictionary
    finally called the viewMenu method
    A menu like system is implemented by recursively calling two different menu options.
    ALL WordMeanings are stored in a LinkedList but definitions and deleted word list are ArrayList(s).
    */
    public static void main(String[] args){
        WordList newDictionary = new WordList("school");
        newDictionary.head.word.addDefinition("An Educational Facility.");
        viewMenu(newDictionary);
    }
    // This initial menu either enters the Dictionary editor/viewer, deleted words list, or closes the application

    public static void viewMenu(WordList newDictionary){
        String allDeletedWords = "";
        for(String words : newDictionary.deletedWords){
            //System.out.println(words);
            allDeletedWords += words + "\n";
        }
        JTextArea deletedWordsList = new JTextArea(allDeletedWords);
        JScrollPane deletedScroll = new JScrollPane(deletedWordsList);

        //options for viewMenu buttons are store into a string called options
        String[] options = {"Dictionary","Deleted","Close"};
        int response1 = JOptionPane.showOptionDialog(null, "Welcome to the Dictionary App\n\n" +
                        "Dictionary: Shows Dictionary options" +
                        "\nDeleted: Shows a list of all deprecated words from the Dictionary"
                , "Dictionary Program",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options,options[0]);

        //Depending on user button press the value is stored into the variable response1 and caught below
        if(response1 == 0) {
            while (true) {
                viewDictionary(newDictionary);
            }
        }
        else if(response1 == 1){
            if(newDictionary.deletedWords.size() == 0){
                int resultant = JOptionPane.showOptionDialog(null, "No Deleted Words",
                        "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, null, null);
                if(resultant == JOptionPane.OK_OPTION){
                    viewMenu(newDictionary);
                }
                else{
                    viewMenu(newDictionary);
                }
            }
            //iterator for delWords ArrayList to display a proper list of words instead of the toString() method
            for(String delWords : newDictionary.deletedWords){
                int resultD = JOptionPane.showOptionDialog(null, deletedScroll,"Deleted Words",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(resultD == JOptionPane.OK_OPTION){
                    viewMenu(newDictionary);
                }
                else{
                    viewDictionary(newDictionary);
                    //System.exit(0);
                }
            }
        }
        else if (response1 == JOptionPane.CLOSED_OPTION || response1 == JOptionPane.CANCEL_OPTION){
            System.exit(0);
        }
    }
    //View Dictionary is another Joptionpane view that allows for viewing/editing the dictionary
    public static void viewDictionary(WordList newDictionary){
        //options add word, delete word, view dictionary, and main manu are stored in an array
        String[] options2 = {"Add Word", "Delete Word", "View Dictionary", "Main Menu"};
        int response2 = JOptionPane.showOptionDialog(null, "Choose an Option",
                "Edit/View Dictionary",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options2,options2[0]);
        //response2 is stored from Joptionpane to determine what to do with it in a form of a switch case statement
        switch(response2){
            case 0:
                //addWord calls the linkedlist methods to insert or delete in there respective spots
                // exceptions are caught and ignored or an error message will display
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
            //
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
            //generates a scrollable list of dictionary terms
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
            //calls the viewmenu() method to return to the Main Menu
            case 3:
                viewMenu(newDictionary);
                break;
            // if CLOSED_OPTION is selected force close the program
            case JOptionPane.CLOSED_OPTION:
                System.exit(0);
                break;
        }
    }
}
