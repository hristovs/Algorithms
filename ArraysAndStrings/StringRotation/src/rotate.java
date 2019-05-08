
public class rotate {
	/*
	 * String Rotation - Given isSubstring only, check if a string 
	 * is a rotation of another string
	 * Hints: #34 - If a string is a rotation of another - then it's a rotation at a particular point
	 * 				and what you're left with is two substrings
	 * 		  #88 - We are essentially asking if there's a way to split the first string into two parts,
	 * 				x and y, such that the first string is xy and the second is yx. I.e x=wat y = erbottle
	 * 				xy = waterbottle, yx = erbottlewat
	 * 	      #104 - Think about concatenating yx with yx 
	 */
	public static void main(String[] args) {
		String baseString = "waterbottlewaterbottlewaterbottlewaterbottlewaterbottlewaterbottle";
		String rotatedString = "bottlewaterbottlewaterbottlewaterbottlewaterbottlewaterbottlewater";
		
		long startTime = System.nanoTime();
		isRotation(baseString,rotatedString);
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		
		long startTime2 = System.nanoTime();
		rotation(baseString,rotatedString);
		long endTime2 = System.nanoTime();
		long duration2 = endTime2 - startTime2;
		System.out.println(isRotation(baseString,rotatedString) + " " + duration);
		System.out.println(rotation(baseString,rotatedString) + " " + duration2);

	}
	
	/*
	 * Naive Solution - isSubstring(String,String) method is given
	 * 
	 */
	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length())  return false;
		String concat = s2.concat(s2);
		if(isSubstring(concat, s1)) return true;
		return false;
	}
	
	public static boolean rotation(String s1, String s2) {
	    int len = s1.length();
	    /* check that s1 and s2 are equal length and not empty */
	    if (len == s2.length() && len > 0) { 
	    	/* concatenate s1 and s1 within new buffer */
	    	String s1s1 = s1 + s1;
	    	return isSubstring(s1s1, s2);
	    }
	    return false;
	}
	
	
	
}
