import java.awt.*;

import javax.swing.*;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.ArrayList;


public class ContentUI implements ActionListener
{
    JFrame frame = new JFrame("Track results");
    static JTextArea tArea = new JTextArea(10,20);
    JButton button = new JButton("Copy excel ready version to clipboard");
    JButton next = new JButton("New file");
    JScrollPane pane = new JScrollPane(tArea);
    SwingWorker worker;
    static String s= "";//some random String
    
    
    public void prepareAndShowGUI()
    {
        Container container = frame.getContentPane();
        container.add(pane);
        container.add(button,BorderLayout.NORTH);
        container.add(next,BorderLayout.SOUTH);
        tArea.setLineWrap(true);
        tArea.setWrapStyleWord(true) ;
        button.addActionListener(this);
        next.addActionListener(this);
        frame.setSize(300,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void standByWindow(){
    	JOptionPane.showMessageDialog(null, "Click",null, JOptionPane.QUESTION_MESSAGE);
    	StartUp.chooseNewFile();
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==button)
        {
            StringSelection selection = new StringSelection(s);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
            JOptionPane.showMessageDialog(null, "Copied to clipboard!");
        }
        else if(evt.getSource()==next){
        	System.out.println("next");
        	StartUp.chooseNewFile();
        }
        

    }
    public static void updateOutput(int slide, String spot){
    	tArea.append("Slide: "+slide +"\tspots: "+spot+"\n");
    	
    }



}
