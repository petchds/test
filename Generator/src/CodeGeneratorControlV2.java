// hello Petch YeYe
// OMG
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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


public class CodeGeneratorControlV2 {
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
	public void ExportFile(String path, String nodeOUT, String nodeIN) {
		String outputPath = "ExportXSLTCode" + ".txt";
		//Check File Existing, then change name to unique file
		File outputFile = new File(outputPath);
		int uniqueID = 1;
		while(outputFile.exists()){
			outputPath = "ExportXSLTCode_" + uniqueID++ + ".txt";
			outputFile = new File(outputPath);
		}
		
		// TODO Auto-generated method stub
		  try {
			  	BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
	            //print text to file
			  	out.write("Node OUT :"+nodeOUT);
			  	out.write("Node IN :"+nodeIN);
			  	out.write("Path :"+path);
			  	out.close();
	            }catch (Exception e) {
	            JOptionPane.showMessageDialog (
	            null,
	            "Error in writing data!!\n\r" + e,
	            "File Save Error",
	            JOptionPane.ERROR_MESSAGE);
	            
	        }
	}
}
