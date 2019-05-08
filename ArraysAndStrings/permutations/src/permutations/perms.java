package permutations;
import java.util.*;
public class perms {
/*
 * Rankings: First Book Algorithm: 3rd
 * 			 My Algorithm: 2nd
 *  		 Second Book Algorithm: 1st
 * 
 */
	public static void main(String[] args) {
		String testString1 = "abcd";
		String testString2 = "";
		String testString3 = "palindromepalindromepalindromepalindromedcbadcbadcbadcbadcbapalindromepalindromepalindromepalindromedcbadcbadcbadcbadcba";
		String testString4 = "palindromepalindromepalindromepalindromedcbadcbadcbadcbadcbapalindromepalindromepalindromepalindromedcbadcbadcbadcbadcba";
		long startTime = System.nanoTime();
		System.out.println(isPermutation(testString1, testString2));
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);

		
		long startTime2 = System.nanoTime();
		System.out.println(permutation(testString1, testString2));
		long endTime2 = System.nanoTime();
		System.out.println(endTime2 - startTime2);
		
		long startTime3 = System.nanoTime();
		System.out.println(perm(testString1, testString2));
		long endTime3 = System.nanoTime();
		System.out.println(endTime3 - startTime3);

		
	}
 /*
  * Naive Solution: boolean isPermutation(String, String)
  * Runs in: O(N)
  * Hint 1: Describe what it means for two strings to be permutations of
  * 	each other. Now, look at that definition you've provided. Can you
  * 	check the strings against that definition.
  * 
  * Hint 84: One solution is O(Nlog(N)), another uses more space but is O(N).
  * 
  * Hint 122: What characteristics would a string that is a permutation of a 
  * 		palindrome have.
  * 
  * Hint 131: Two strings that are permutations should have the same characters, 
  * 		but in different orders. Can you make the orders the same?
  */
	static boolean isPermutation(String perm1, String perm2){
		if(perm1.length() != perm2.length()) return false;
		int permVal1 = 0;
		int permVal2 = 0;
		for(int i = 0; i < perm1.length(); i++) {
			int val = perm1.charAt(i);
			int val2 = perm2.charAt(i);
			permVal1 = val + permVal1;
			permVal2 = val2 + permVal2;
		}
		
		if(permVal1 == permVal2) return true;
	   
		return false; 
	}
	
	
	/*
	 * Book Algorithms
	 * Two different solutions from the book
	 * First: Similiar to boolean array
	 * first for loop populates an int array of 128 which 
	 * are instanciated with the value 0
	 * they are incremented to the value 1 at the position of each letter
	 * in the first word.
	 * The second string decrements this array by 1, and if any value in
	 * the int array drops below 0 it means that there are characters
	 * not found in the first word, meaning the words arent permutations
	 */
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) return false; // Permutations must be same length
		
		int[] letters = new int[128]; // Assumption: ASCII
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
		}
		  
		for (int i = 0; i < t.length(); i++) {
			letters[t.charAt(i)]--;
		    if (letters[t.charAt(i)] < 0) {
		    	return false;
		    }
		}
		  
		return true; // letters array has no negative values, and therefore no positive values either
	}
	
	
	/*
	 * Second book algorithm:
	 * Sorts the two strings,
	 * compares with .equals()
	 */
	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean perm(String s, String t) {
		return sort(s).equals(sort(t));
	}	
	
	
}
