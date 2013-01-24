package prog.common;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import prog.map.InstanceNode;
import prog.map.NodeXml;


public class _NodeDom {

	public _NodeDom() {
	}

	public Boolean checkValue(String str){
		Boolean value = false;
		try{
		if(str.indexOf('?')!=-1){
			value = true;
		}}catch (Exception e) {
			 value = false;
		}
		return value;
	}

	public String findValue(Object obj,String nodeName,Map<String, Object> mapstr){
		
		String value ="?";
		if(mapstr!=null && mapstr.get(nodeName) != null){		
			value  = mapstr.get(nodeName).toString();
			String instance = InstanceNode.InstanceNode(nodeName);
		 	value =(instance=="" ? value :instance);
		}	
		else{
			value = NodeXml.getValue(nodeName,obj);
			}

	return  value;
	}
	
	public void setNodeValue(NodeList nList,Object obj,int index,Map<String, Object> mapstr){

		if (nList.item(index).getChildNodes() != null)
		   {
			NodeList nodeList =  nList.item(index).getChildNodes(); 
			   if(Child(nodeList,obj,mapstr)){
				   nList.item(index).getFirstChild().setNodeValue(findValue(obj,nList.item(index).getNodeName(), mapstr));
			   }
		   }
		if (nList.item(index).getAttributes() != null)
		   {
			   NamedNodeMap attr2 = nList.item(index).getAttributes();
			   for (int i = 0; i < attr2.getLength(); i++) {
				   if(attr2.item(i).getNodeValue().indexOf('?')!=-1){
					attr2.item(i).setNodeValue("?");
				   }
			   }
		   }
		
	}

	public void useMethod_setDom (NodeList nList,Object obj,Integer index ,Map<String, Object> mapstr){

		for (Method method : obj.getClass().getDeclaredMethods())
		{
			if(method.getName() =="SetDom"){
			try {
				method.invoke(obj, nList, obj, index, mapstr);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e){
				e.printStackTrace();
			}
		}}	
	}
	
	public Boolean Child(NodeList nList,Object obj,Map<String, Object> mapstr){
		Boolean  value = false;
		for (int index = 0; index < nList.getLength(); index++) {
			useMethod_setDom( nList, obj, index, mapstr);
			if(checkValue(nList.item(index).getNodeValue()))
				return true;
		}
		return value;
	}

}
