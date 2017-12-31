import javax.swing.*;
import java.io.*;

public class BasicFile {
    File file;

    public BasicFile(){
        JFileChooser fileChooser = new JFileChooser(".");
        int status = fileChooser.showOpenDialog(null);

        try{
            if(status != JFileChooser.APPROVE_OPTION){
                throw new IOException();
            }
            file = fileChooser.getSelectedFile();
            if(!file.exists()){
                throw new FileNotFoundException();
            }
        }

        catch(FileNotFoundException e){
            display("File not found", e.toString(), JOptionPane.WARNING_MESSAGE);
        }
        catch(IOException e){
            display("Approved option was not selected", e.toString(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public BasicFile(String something){
        JFileChooser fileChooser = new JFileChooser(".");
        int status = fileChooser.showSaveDialog(null);
        try{
            if(status == JFileChooser.APPROVE_OPTION){

            }
            else{
                throw new IOException();
            }
        }
        catch(IOException e){
            display("You have canceled", e.toString(), JOptionPane.WARNING_MESSAGE);
        }
    }


    private void display(String msg, String s, int t){
        JOptionPane.showMessageDialog(null,msg,s,t);
    }

    String getFileName(){
        return file.getName();
    }

    String getContent(){
        String s;
        String str = "";

        try{
            LineNumberReader lineNumebrReader = new LineNumberReader(new FileReader(file));
            while((s = lineNumebrReader.readLine()) != null){
                str = str + s + "\n";
            }
        }

        catch(IOException e){

        }
        return str;
    }


}
