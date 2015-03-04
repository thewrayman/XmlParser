import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class xmlParse {
	
	public static void parseFile(){
		
		try {
			 
			File fXmlFile = new File(StartUp.fp);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			doc.getDocumentElement().normalize();
		 
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		 
			NodeList nList = doc.getElementsByTagName("particle");
		 
			System.out.println("----------------------------");
			ContentUI.s = "";
			ContentUI.s = StartUp.fp + "\n";
			ContentUI.tArea.setText("");
			ContentUI.tArea.append(StartUp.fp+"\n");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					
					String spots = eElement.getAttribute("nSpots");
					
					ContentUI.updateOutput(temp,spots);
					ContentUI.s  = ContentUI.s + temp +"\t"+ spots + "\n";
/*					
					System.out.print("Slide number: " + temp);
					System.out.println(", Spot number: " + spots);*/

					
				}
			}
			System.out.println(ContentUI.s);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  }
		
		
	}

