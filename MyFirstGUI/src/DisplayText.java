import javax.swing.*;
import java.awt.*;

public class DisplayText {
    private JTextArea text;

    public DisplayText(String name, String content){
        MyJFrame frame = new MyJFrame(name);
        Container container = frame.getContentPane();
        text = new JTextArea(content);
        JScrollPane scrollPane = new JScrollPane(text);
        container.add(scrollPane);
        frame.setBounds(Constants.X_POS, Constants.Y_POS, 500, 400);
        frame.setVisible(true);
    }
}
