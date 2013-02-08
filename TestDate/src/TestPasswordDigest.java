import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

//import org.springframework.util.DigestUtils;

public class TestPasswordDigest {

	/**
	 * @param args
	 * @throws ParseException
	 * @throws NoSuchAlgorithmException
	 */
	public TestPasswordDigest() throws ParseException, NoSuchAlgorithmException {
		// TODO Auto-generated constructor stub

		String nonce = "qua";
		Date created = Calendar.getInstance().getTime();// quae divum
														// ince112012-12-20T22:25:35Zabcdabcdefg
		SimpleDateFormat xmlDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'");
		xmlDateFormat.setTimeZone(TimeZone.getTimeZone("TH"));
		Date xx = xmlDateFormat.parse("2012-12-20T15:53:46Z");
		// xx = xx + 252000000; 7*60*60*1000

		created.setTime(xx.getTime() + 25200000);
		String password = nonce + xmlDateFormat.format(created) + "Fuck"
				+ "NULL";
		System.out.println(password);
		// String passwordDigest =
		// DigestUtils.md5DigestAsHex(password.getBytes());
		// System.out.println(passwordDigest);
		//
		// int[] a = {1};//{1}
		// String as = "1";//{31}

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		System.out.println(new BigInteger(1, md.digest()).toString(16));
		//
		// System.out.println(DigestUtils.md5DigestAsHex("1".getBytes()));
		// System.out.println(DigestUtils.md5DigestAsHex(as.getBytes()));
		// UserCompany userCompany =
		// clientManagementService.authenticate("tgadmin", passwordDigest,
		// nonce, created);

	}

	public TestPasswordDigest(String password, String nonce, String date,
			String secretKey) throws ParseException, NoSuchAlgorithmException {
		// TODO Auto-generated constructor stub

		Date created = Calendar.getInstance().getTime();// quae divum
														// ince112012-12-20T22:25:35Zabcdabcdefg
		SimpleDateFormat xmlDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'");
		xmlDateFormat.setTimeZone(TimeZone.getTimeZone("TH"));
		Date xx = xmlDateFormat.parse(date);
		// xx = xx + 252000000; 7*60*60*1000

		created.setTime(xx.getTime() + 25200000);
		String password1 = nonce + xmlDateFormat.format(created) + password
				+ secretKey;
		System.out.println(password1);
		// String passwordDigest =
		// DigestUtils.md5DigestAsHex(password1.getBytes());
		// System.out.println(passwordDigest);

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password1.getBytes());
		System.out.println(new BigInteger(1, md.digest()).toString(16));

		// UserCompany userCompany =
		// clientManagementService.authenticate("tgadmin", passwordDigest,
		// nonce, created);

	}

	public TestPasswordDigest(String password, String nonce, String date,
			String secretKey, String userName) throws ParseException, NoSuchAlgorithmException, IOException {
		// TODO Auto-generated constructor stub

		Date created = Calendar.getInstance().getTime();// quae divum
														// ince112012-12-20T22:25:35Zabcdabcdefg
		SimpleDateFormat xmlDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'Z'");
		xmlDateFormat.setTimeZone(TimeZone.getTimeZone("TH"));
		Date xx = xmlDateFormat.parse(date);

		created.setTime(xx.getTime() + 25200000);
		String password1 = nonce + xmlDateFormat.format(created) + password
				+ secretKey;
		System.out.println(password1);

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password1.getBytes());
		password = new BigInteger(1, md.digest()).toString(16);
		System.out.println(password);

		FileWriter fw = new FileWriter("userName.xml");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append("<bas:usernameToken>\n");
		bw.append("\t<bas:username>"+userName+"</bas:username>\n");
		bw.append("\t<bas:passwordDigest>"+password+"</bas:passwordDigest>\n");
		bw.append("\t<bas:nonce>"+nonce+"</bas:nonce>\n");
		bw.append("\t<bas:created>"+date+"</bas:created>\n");
		bw.append("</bas:usernameToken>\n");
		bw.flush();
		bw.close();
//		<bas:usernameToken>
//        <bas:username>tgadmin</bas:username>
//        <bas:passwordDigest>02f89a63173618959caa5af3ab47982f</bas:passwordDigest>
//        <bas:nonce>abcd</bas:nonce>
//        <bas:created>2006-08-20T00:27:14Z</bas:created>
//     </bas:usernameToken>
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 0) {
			System.out.println("The arguments are : dateTime in 'tz' , secretkey, password, nounce");
			try {
				new TestPasswordDigest(args[2], args[3], args[0],args[1]);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				// new TestPasswordDigest();
				new TestPasswordDigest("1234", "abcde", "2012-12-20T16:31:07Z",
						"xx","Golf");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
