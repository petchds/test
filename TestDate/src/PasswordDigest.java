import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;


public class PasswordDigest {
	
//	generatePasswordDigest($username, $password, $secretKey){
//        $nonce = md5(date('Y-m-d H:i:s:u'). $username);
//        $created = date('Y-m-d\TH:i:s\Z');
//
//        $passwordDigest = md5($nonce.$created.$password.$secretKey);
//		return $passwordDigest;
	public static String gen(String username, String pasword, String secretKey) throws Exception{
		
		MessageDigest md = MessageDigest.getInstance("MD5");		
		Calendar cal = Calendar.getInstance(new Locale("en", "EN"));
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");//, Locale.UK);
		fmt.setCalendar(cal);
		String date = fmt.format(new Date());
		StringTokenizer tok = new StringTokenizer(date,"T");
		String prepareString = tok.nextToken()+" "+tok.nextToken()+username;
		md.update(prepareString.getBytes(), 0, prepareString.length());
		String nounce = new BigInteger(1, md.digest()).toString(16); 
		prepareString = nounce+date+pasword+secretKey;
		md.reset();
		md.update(prepareString.getBytes(),0, prepareString.length());
		nounce = new BigInteger(1, md.digest()).toString(16);
		return nounce;
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PasswordDigest pwd = new PasswordDigest();
		System.out.println(pwd.gen("Petch", "hello", "abcd"));

	}

}
