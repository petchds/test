package prog.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


import java.io.BufferedWriter;

public class _GenObject extends _mapDB{

	public _GenObject() {
		// TODO Auto-generated constructor stub
	}
	
	public void SetXML(NodeList nList,Object obj,Map<String, Object> mapstr){
		
				Class<? extends _NodeDom> clazz =(Class<? extends _NodeDom>) obj.getClass();
				try {
					_NodeDom  nd= clazz.newInstance();
					nd.Child(nList, obj, mapstr);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
	}


	public void WriteFile(String FromFileXML, Object obj ,String ToFolder,String ToFile) throws Exception, IOException  {
	
		(new File(ToFolder)).mkdirs();
		File fXmlFile = new File(FromFileXML);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		SetXML(doc.getChildNodes(),obj,null);
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		StringWriter buffer = new StringWriter();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(new DOMSource(doc),new StreamResult(buffer));
		String path = ToFolder+"/"+ToFile;
		File file = new File(path);
		BufferedWriter  output =  new BufferedWriter(new FileWriter(file));
		output.write(buffer.toString());
		output.close();
	}
}
