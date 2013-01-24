package prog.domain.gateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import prog.common._NodeDom;

public class GateWay extends _NodeDom{

    private Map<String, Object> Control;
    private LinkedList<Map<String, Object>> Detail = new LinkedList<Map<String, Object>>();
    private String[][] fieldControl;
    private String[][] fieldDetail;
    private Connection con;

    public GateWay() {
    }
    
    public Map<String, Object> getAmanControl() {
            return Control;
    }

    public void setAmanControl(Map<String, Object> amanControl) {
            Control = amanControl;
    }

    public LinkedList<Map<String, Object>> getAmanDetail() {
            return Detail;
    }

    public void setAmanDetail(LinkedList<Map<String, Object>> amanDetail) {
            Detail = amanDetail;
    }

  
    public void SetDom(NodeList nList,Object obj,int index,Map<String, Object> mapstr){

            switch (nList.item(index).getNodeName()) {
            case "DocumentHeader":
            	     setNodeValue(nList,obj, index,((GateWay)obj).getAmanControl());
                    break;
            case "DocumentDetailsTransport":
            if(((GateWay)obj).getAmanDetail().size()>0){
            		Node tempNode = nList.item(index).cloneNode(true);
                    setNodeValue(nList,obj, index ,((GateWay)obj).getAmanDetail().getFirst());
                    ((GateWay)obj).getAmanDetail().removeFirst();
                    if(((GateWay)obj).getAmanDetail().size()>0){
                    nList.item(index).getParentNode().appendChild(tempNode);
                    }
            }
            break;
            default:
                    setNodeValue(nList,obj, index,mapstr);
                    break;
            }

    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @param fieldControl the fieldControl to set
     */
    public void setFieldControl(String[][] fieldControl) {
        this.fieldControl = fieldControl;
    }

    /**
     * @param fieldDetail the fieldDetail to set
     */
    public void setFieldDetail(String[][] fieldDetail) {
        this.fieldDetail = fieldDetail;
    }
    
    

    public String[][] setResultset(ResultSet rs,String[][] str) throws SQLException{  
        for (int i = 0; i < str.length; i++) {
            str[i][1] = rs.getString(i+1);
        }
         return str;
    }
    
//    public Map<String,Object> getDBAmanControl(String sqlCommand) throws SQLException{
//      
//      Map<String, Object> params = new HashMap<String, Object>(fieldControl.length);	
//
//      Statement st = con.createStatement();
//      ResultSet rs = st.executeQuery(sqlCommand);
//      ResultSetMetaData md = rs.getMetaData();
//      while(rs.next()){
//          if(fieldControl.length == md.getColumnCount()){
//          	//map filed
//              params = mapStr(setResultset(rs,this.fieldControl));
//              Map<String, Object> params2= new HashMap<String, Object>(md.getColumnCount());
//              for (int i = 0; i < str.length; i++) {
//                  params2.put(str[i][0],str[i][1]);
//              }
//          }
//      }
//      return params;
//  }
//    
    
    public void getListrow(String sqlCommand,)
    
//    
//    
//    /**
//     * 
//     * @param str
//     * @return
//     */
//    public Map<String,Object> mapStr(String[][] str){
//        Map<String, Object> params = new HashMap<String, Object>(str.length);
//        for (int i = 0; i < str.length; i++) {
//            params.put(str[i][0],str[i][1]);
//        }
//       return params;
//    }
//    
//    public Map<String,Object> getDBAmanControl(String sqlCommand) throws SQLException{
//        
//        Map<String, Object> params = new HashMap<String, Object>(fieldControl.length);	
//
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(sqlCommand);
//        ResultSetMetaData md = rs.getMetaData();
//        while(rs.next()){
//            if(fieldControl.length == md.getColumnCount()){
//            	//map filed
//                params = mapStr(setResultset(rs,this.fieldControl));
//                Map<String, Object> params2= new HashMap<String, Object>(md.getColumnCount());
//                for (int i = 0; i < str.length; i++) {
//                    params2.put(str[i][0],str[i][1]);
//                }
//            }
//        }
//        return params;
//    }
//
//    
//    public LinkedList<Map<String, Object>> getDBAmanDetail(String sqlCommand) throws SQLException{
//        
//        Map<String, Object> params = new HashMap<String, Object>(fieldDetail.length);	
//        LinkedList<Map<String, Object>> List = new LinkedList<Map<String, Object>>();
//        
//        Statement st = con.createStatement();
//        ResultSet rs = st.executeQuery(sqlCommand);
//        ResultSetMetaData md = rs.getMetaData();
//        while(rs.next()){
//            if(fieldDetail.length == md.getColumnCount()){
//                //map field and add item into list
//            	params = mapStr(setResultset(rs,this.fieldDetail));
//                List.add(params);
//            }
//        }
//        return List;
//    }
}
