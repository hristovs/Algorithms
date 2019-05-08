import java.lang.Math;
public class oneaway {
	/*
	 * Design a function to return whether a string is one insert,replace,delete from another string
	 * Hints: #23 - Can you check the conditions separately
	 * 		  #97 -  What is the relationship between insert and remove, do they need to be separete checks 
	 * 		  #130 - Can you do all three checks in a single pass
	 */
	public static void main(String[] args) {

		String testString1 = "abcde";
		String testString2 = "acbbbb";
		/*
		 * long startTime = System.nanoTime(); System.out.println(oneAway(testString1,
		 * testString2)); long endTime = System.nanoTime(); System.out.println(endTime -
		 * startTime);
		 */
		long startTime2 = System.nanoTime();
		System.out.println(oneEditAway(testString1, testString2));
		long endTime2 = System.nanoTime();
		System.out.println(endTime2 - startTime2);

	}

	/*
	 * naive approach
	 */
	
	
	static boolean oneAway(String str1, String str2) {
		int str1Len = str1.length();
		int str2Len = str2.length();
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		int difference = Math.abs(str1Len - str2Len);
		//check that strings arent more than 1 away in terms of length
		if(difference > 1) return false;
		
		int[] charSet = new int[26];
		for(int i = 0; i < str1Len; i++) {
			int val = charArr1[i];
			charSet[val-97]++;
			
		}
		for(int i = 0; i < str2Len; i++ ) {
			int val = charArr2[i];
			if(charSet[val-97] > 0) {
			charSet[val-97]--;
			}
		}
		int sum = 0;
		for(int i = 0; i < 26; i++) {
			sum += charSet[i];
		}
		if(difference == 0) {
			if(sum == 0 || sum==1) return true;
		}
		else {
			System.out.println(sum);
			if(sum == 1) return true;
		}

		return false;
	}
	
	
	
	/*
	 * book solution
	 */
	public static boolean oneEditAway(String first, String second) {
		/* Length checks. */
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		/* Get shorter and longer string.*/
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;

		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				/* Ensure that this is the first difference found.*/
				if (foundDifference) return false;
				foundDifference = true;
				if (s1.length() == s2.length()) { // On replace, move shorter pointer
					index1++;
				}
			} else {
				index1++; // If matching, move shorter pointer 
			}
			index2++; // Always move pointer for longer string 
		}
		return true;
	}
	
	
	
	
	
	
}
