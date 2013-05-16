import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;


import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class CodeGeneratorControl implements ClipboardOwner{
	
	
	public String pathfinder(String directory, String target){
		String output = "";
			try {
				Scanner scan = new Scanner(new File(directory));
				String line = "";
				while(scan.hasNext()){
					line += scan.nextLine();
				}
				scan.close();
				Document dom = convertToDom(line);
				
				output=target;
				NodeList list = dom.getElementsByTagName(target);
							
				for(int i = 0 ; i < list.getLength() ; i++){
					Node node = list.item(i);
					while (node.getParentNode() != null) {
						node = node.getParentNode();
						output = node.getNodeName() + "/" + output;
					}				
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		return output.substring(9);
	}
	public static Document convertToDom(String xmlString){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document returnDocument = null;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader(xmlString)));    
			
			if(document !=null){
				System.out.println("Succcess Parsing Document");
				returnDocument = document;
				return returnDocument;
			}
			else{
				System.out.println("Null Document");
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnDocument;
	}
	
	public static void convertDomToFile(Document document, String filePath){
		try {
			 TransformerFactory tFactory =
					    TransformerFactory.newInstance();
					    Transformer transformer = 
					    tFactory.newTransformer();

					    DOMSource source = new DOMSource(document);
					    StreamResult result = new StreamResult(new File(filePath));
					    transformer.transform(source, result);
		
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CodeGeneratorControl.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
	}
	public void copyToClipboard(String input){
		StringSelection stringSelection = new StringSelection( input );
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents( stringSelection, (ClipboardOwner) this );
	}
	@Override
	public void lostOwnership(Clipboard arg0, Transferable arg1) {
		// TODO Auto-generated method stub
		
	}

	

	

	
}
