
public class CallException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestException exc = new TestException();
		try {
			exc.isMessage(8);
		} catch (TestException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
