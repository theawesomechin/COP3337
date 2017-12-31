import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Actions implements ActionListener{
    DisplayText displayText;
    BasicFile file;

    public void actionPerformed(ActionEvent event){
        String eventS = event.getActionCommand();
        switch(eventS){
            case"New":
                displayText = new DisplayText("Untitled", "");
                break;
            case"List Files":
                file = new BasicFile();
                displayText = new DisplayText(file.getFileName(), file.getContent());
                break;
            case"Save As":
                file = new BasicFile("save");
                break;
            case"Close":
                System.exit(0);
                break;
            case"Copy":
                displayText.selectText();
                break;
            case"Paste":
                displayText.insertText();
            default:
                System.exit(1);
                break;
        }
    }
}
