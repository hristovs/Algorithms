package palindromePermutation;

public class pPerm {
	/*
	 * Palindrome Permutation - Check if a string can be a palindrome if rearranged
	 * Hints: #106 - Don't generate all permutations
	 * #121 - What are this string's characteristics
	 * #134 - Hash table?
	 * #136 - Bit vector?
	 */
	public static void main(String[] args) {
		
		String testString = "live on time emit no evil";
		System.out.println(isPalindrome(testString));
	}
	/*
	 * naive approach
	 */
	static boolean isPalindrome(String str) {
		char[] pArr = str.toCharArray();
		int[] charSet = new int[28];
		
		for(int i = 0; i < pArr.length; i++) {
			int val = pArr[i];
			if(val != ' ') {
				if(charSet[val-97] == 0) {
					charSet[val-97]++;
				}
				else {
					charSet[val-97]--;
				}
			}
		}
		int counter = 0;
		for(int i=0; i<28; i++) {
			if(charSet[i] > 0 ) {
				counter++;
			}
		}
		if(counter > 1) return false;
		else return true;
	}

}
