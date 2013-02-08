
public class TestException extends NumberFormatException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TestException() {
		// TODO Auto-generated constructor stub
	}
	
	public TestException(String processingIndicator) {
        super(String.format("The specified processingIndicator[%s] is not allowed.", processingIndicator));
    }
	
	public boolean isMessage(int x) throws TestException{
		if(x==1){
			return true;
		}else if(x==2)
			return true;
		else if (x==9)
			return true;
		else
			throw new TestException("Not a message");
//			return false;
	}
}
