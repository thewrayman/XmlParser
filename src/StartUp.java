import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class StartUp {

	public static String fp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		chooseFile();
		xmlParse.parseFile();
		
        ContentUI contui = new ContentUI();
        contui.prepareAndShowGUI();
	}
	
	
	
	public static String getFileName(){
		
		String value= JOptionPane.showInputDialog("Input the file name with .xml: ");
		
		System.out.println(value);
		return value;
		
	}
	
	public static String chooseFile(){
		JFileChooser jfc = new JFileChooser();
	    jfc.showDialog(null,"Please Select the File");
	    jfc.setVisible(true);
	    File filename = jfc.getSelectedFile();
	    System.out.println("File name "+filename.getName());
	    
	    fp = jfc.getSelectedFile().getAbsolutePath();
	    System.out.println(fp);
	    return fp;
	}
	
	public static String chooseNewFile(){
		File curdir = new File(fp);
		System.out.println("current dir: "+fp);
		JFileChooser jfc = new JFileChooser(curdir);
		
	    jfc.setCurrentDirectory(curdir);
	    jfc.showDialog(null,"Please Select the File");
	    jfc.setVisible(true);
	    
	    File filename = jfc.getSelectedFile();
	    System.out.println("File name "+filename.getName());
	    
	    fp = jfc.getSelectedFile().getAbsolutePath();
	    System.out.println(fp);
	    xmlParse.parseFile();
	    return fp;
	}

}
