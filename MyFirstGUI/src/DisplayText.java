import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class DisplayText{
    public JTextArea text;
    String copiedText = "";

    public DisplayText(String name, String content){
        MyJFrame frame = new MyJFrame(name);
        Container container = frame.getContentPane();
        text = new JTextArea(content);
        JScrollPane scrollPane = new JScrollPane(text);
        container.add(scrollPane);
        frame.setBounds(Constants.X_POS, Constants.Y_POS, 500, 400);
        frame.setVisible(true);
    }

    public void selectText(){
            try{
                copiedText = text.getSelectedText();
            }
            catch (NullPointerException e){
                System.out.println("Exception is here");
            }

    }

    public void insertText(){
        text.replaceSelection(copiedText);
        System.out.println("Paste");
    }

}
