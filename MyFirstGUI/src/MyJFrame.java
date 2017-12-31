/*
*   Author: Gavin Chin
*   Date: Dec. 10, 2017
*   Assignment 6
*/
import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame implements Constants {

    JMenu menu;
    JMenuBar menuBar;
    JMenuItem menuItem;
    ButtonGroup buttonGroup = new ButtonGroup();

    public static void main(String[] args){
        MyJFrame frame = new MyJFrame(Constants.TITLE); //Calling the frame construcutor

        Toolkit tool = frame.getToolkit(); // Retrieves frame features
        Dimension size = tool.getScreenSize(); // Retrieves screen size

        Rectangle rectangle = new Rectangle(Constants.X_POS, Constants.Y_POS, size.width/Constants.WIDTH, 2* size.height/Constants.HEIGHT);

        frame.setBounds(rectangle);
        frame.setVisible(true);

        

    }

    public MyJFrame(String title){
        super(title);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        buildMenu(); //Build the entire menu
    }

    public void buildMenu(){
        for(int i = 0; i < Constants.MENUBAR.length; i++){
            menu = new JMenu(Constants.MENUBAR[i]);
            switch(i){
                case 0:
                    for(int j = 0; j < Constants.FILE.length; j++){
                        menuItem = new JMenuItem(Constants.FILE[j]);
                        if(Constants.FILE[j].equals("List Files") || Constants.FILE[j].equals("Save As")){
                            menu.add(menuItem);
                            menu.addSeparator();
                            menuItem.addActionListener(new Actions());
                        }
                        else{
                            menu.add(menuItem);
                            menuItem.addActionListener(new Actions());
                        }
                    }
                    break;
                case 1:
                    for(int j = 0; j < Constants.TOOL.length; j++){
                        JMenuItem cascadeItem;
                        menuItem = new JMenuItem(Constants.TOOL[j]);
                        if(Constants.TOOL[j].equals("Search")){
                            menu.add(menuItem);
                            menuItem.addActionListener(new Actions());
                            menu.addSeparator();
                        }
                        else if(Constants.TOOL[j].equals("Edit")){
                            JMenu cascadeMenu = new JMenu(Constants.TOOL[j]);

                            for(int l = 0; l < Constants.EDIT.length; l++){
                                cascadeMenu.add(cascadeItem = new JMenuItem(Constants.EDIT[l]));
                                cascadeItem.addActionListener(new Actions());
                                buttonGroup.add(cascadeItem);
                            }
                            menu.add(cascadeMenu);
                        }
                        else{
                            menu.add(menuItem);
                            menuItem.addActionListener(new Actions());
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    break;
            }

            menuBar.add(menu);
        }
    }

}
