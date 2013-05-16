import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class ConverterControl implements ClipboardOwner {
	public String convertToTIS(String input){
		String tis = "";
		try {
			tis = URLEncoder.encode(input, "TIS-620");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "Encoding error";
		}
		return tis;
	}
	
	public String convertToText(String input){
		String txt = "";
		try {
			txt = URLDecoder.decode(input, "TIS-620");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return "Decoding error";
		}
		return txt;
	}
	
	public void copyToClipboard(String input){
		StringSelection stringSelection = new StringSelection( input );
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents( stringSelection, this );
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		//do nothing
	}
}
