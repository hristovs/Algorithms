
public class compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static String compress(String str) {
		int finalLength = countCompression(str);
		//check if worth doing
		if(finalLength >= str.length()) return str;
		
		StringBuffer compressed = new StringBuffer(finalLength);
		int countConsecutive = 0;
		
		for(int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	
	
	
	static int countCompression(String str) {
		int cLength = 0;
		int countConsecutive = 0;
		
		
		for(int i =0; i < str.length(); i++) {
			countConsecutive++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				cLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return cLength;
	}
}
