
public class rotate {
		/*
		 * rotate NxN matrix 90 degrees.
		 * Hints: #51 - Layer by layer
		 * 		  #100 - Swap values in four arrays
		 * 
		 */
	public static void main(String[] args) {
		
	}
	
	static boolean rotate(int[][] pix) {
		if(pix.length == 0 || pix.length != pix[0].length) return false; // not a squre
		
		int n = pix.length;
		
		for(int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer;
			
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = pix[first][i];
				
				pix[first][i] = pix[last-offset][first];
				pix[last-offset][first] = pix[last][last-offset];
				pix[last][last-offset] = pix[i][last];
				pix[i][last] = top;
				
			}
		}
		return true;
	}
}
