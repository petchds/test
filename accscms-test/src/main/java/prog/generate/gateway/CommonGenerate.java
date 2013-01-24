package prog.generate.gateway;

import java.io.IOException;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.Map;

import Domain.Common;

public class CommonGenerate extends _GenObject{
	public String formFile;
    public String toFolder;
    public String name;
    public int length;
    
    public void run() throws IOException, Exception{
    	Common common = new Common();
  		for (int i = 1; i <= length; i++) {		
	     		WriteFile(formFile, common, toFolder, name.concat(Integer.toString(i)).concat(".xml"));
  		}
        
  	}
	

}
