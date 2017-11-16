import javax.swing.*;

public class Dictionary {

    public static void main(String[] args){

        WordList newDictionary = new WordList("Apple");
        JTextArea deletedWordsList = new JTextArea(newDictionary.deletedWords.toString());
        JScrollPane deletedScroll = new JScrollPane(deletedWordsList);
        String[] options = {"Cancel","Deleted", "Dictionary"};
        int response = JOptionPane.showOptionDialog(null, "Welcome to the Dictionary App\n\n" +
                        "Dictionary: Shows in a scrollable window all the Words and there definitions" +
                        "\nDeleted: Shows a list of all deleted words from the Dictionary"
                , "Dictionary Program",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options,options[0]);
        switch(response){
            case 0:
                System.exit(0);
                break;
            case 1:

                JOptionPane.showMessageDialog(null, deletedScroll,"Deleted Words",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
                break;
            case 2:

                break;
            default:
                break;
        }
    }
}
