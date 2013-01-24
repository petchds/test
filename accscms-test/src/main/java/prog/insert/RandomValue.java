package prog.insert;

public class RandomValue {


	public static String Func1(String str){
	char[] charArray = str.toCharArray();
	String  value = "";
	
	for (int i = 0; i < charArray.length; i++) {
		switch(charArray[i]){
		
		case 'i':	value = value + (int)(Math.random()*10);
					break;
		case 's':	value = value.concat(Character.toString((char) (97+(int)(Math.random()*26))));
					break;
		case 'S':	value = value.concat(Character.toString((char) (65+(int)(Math.random()*26))));
					break;
		default:	value = value.concat(Character.toString(charArray[i]));
					break;
		}}
	return value;
	}
	
	
	
	
	public static String Func2(){
		int length = (int)(Math.random()*100)/5;
		String value = "";
		int Character ;
		
		length = length > 5 ? length : 5;
		
		for (int i = 0; i < length; i++) {
			Character =(int)(Math.random()*10);
			Character = Character >= 3 ? Character >= 6 ?  3: 2 : 1;
			
			
		switch (Character) {
		case 1:
			value = value.concat("i");
			break;
		case 2:
			value = value.concat("s");
			
			break;
		case 3:
			value = value.concat("S");
			
			break;	
		default:
			break;
		}}
		
		return  Func1(value);
		
	}

	

}
