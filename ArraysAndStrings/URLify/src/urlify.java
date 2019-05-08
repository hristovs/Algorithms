
public class urlify {
/*
 * Task: Turn string into URL string by adding %20 in white spaces
 * Hints: #53 - It's often easiest to modify strings by going from the end of the string to the beginning.
 * 	 	  #118 - You might find you need to know the number of spaces. Can you just count them? 
 * 
 */
	public static void main(String[] args) {
		String testString = "a b c";
		long startTime = System.nanoTime();
		String returnString = urlify(testString);
		System.out.println(returnString);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		char[] arr = testString.toCharArray();
//		int trueLength = findLastCharacter(arr) + 1;
//		long startTime2 = System.nanoTime();
//		replaceSpaces(arr, trueLength);	
//		long endTime2 = System.nanoTime();
//		System.out.println(endTime2 - startTime2);
	}

	/*
	 * Naive Solution
	 * counts white spaces
	 * uses that to determine size of urlify array
	 * iterates through original string, replaces whitespace with %20
	 * String builder appends chars from array together, returns as string
	 */
	static String urlify(String str) {
		int counter = 0;
		char space = ' ';
		char u = '%';
		char r = '2';
		char l = '0';
		
		//count white spaces
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == space) counter++;
		}
		
		//initialize char array as 
		char[] charArr = new char[str.length() +((counter*2))];

		char[] strArr = str.toCharArray();
		int j = 0;
		for(int i = 0; i < strArr.length; i++) {
			if(strArr[i] == space) {

				charArr[j] = u;
				j++;
				charArr[j] = r;
				j++;
				charArr[j] = l;
				j++;
			}
			else {

				charArr[j] = strArr[i];

				j++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch: charArr) {
			sb.append(ch);
		}

		return sb.toString();
	}
	
	
	/*
	 * Urlify - optimized
	 * 
	 */
	
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length) str[trueLength] = '\0';
		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	
}
