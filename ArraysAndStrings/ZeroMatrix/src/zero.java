
public class zero {
	
	/*
	 * Zero entire column and row if any 0 in the column
	 * #102 - Need Data Storage - Maybe use matrix itself
	 * #74 - What information is really needed?
	 * #17 - Try finding zeroes first
	 */
	public static void main(String[] args) {
		int[][] arr = {{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},{0,4,3,2,4,6,6,6,6,6,6,6,6,}, 
				{3,3,0,3,3,3,3,3,3,4,5,6,7},{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5},
				{5,4,3,2,1,5,4,32,1,1,1,1,13},{5,5,5,5,5,5,0,5,5,5,5,5,5}};
		long startTime = System.nanoTime();
		zeroMatrix(arr);
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
		long startTime2 = System.nanoTime();
		setZeros(arr);
		long endTime2 = System.nanoTime();
		System.out.println(endTime2 - startTime2);
		
	}
	/*
	 * 
	 * brute force
	 */
	static void zeroMatrix(int[][] array) {
		int counter = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length;j++) {
				if(array[i][j] == 0) counter++;
			}
		}
		int[] x = new int[counter];
		int[] y = new int[counter];
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == 0) {
					x[count]=i;
					y[count]=j;
					count++;
				}
			}
		}
		
		for(int i = 0; i < counter; i++) {
			for(int j = 0; j < array[x[i]].length ;j++) {
				array[x[i]][j] = 0;
			}
		}
		
		for(int i = 0; i < counter; i++) {
			for(int j = 0; j < array.length ;j++) {
				if(array[j].length >=y[i]) array[j][y[i]] = 0;
			}
		}
		
	}
	
	
	
	/*
	 * 
	 * book solution
	 */
	
	
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}		
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}		
	}		
	
	public static void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;		
		
		// Check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}		
		
		// Check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}		
		
		// Check for zeros in the rest of the array
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
		 		}
			}
		}		
		
		// Nullify rows based on values in first column
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}		
		
		// Nullify columns based on values in first row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}	
		
		// Nullify first row
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}
		
		// Nullify first column
		if (colHasZero) {
			nullifyColumn(matrix, 0);
		}
	}	
	
	public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		
		for (int k = 0; k < m1.length; k++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (m1[k][j] != m2[k][j]) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	
	
	
	

}
