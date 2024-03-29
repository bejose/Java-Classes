

/**
 * This class represents a matrix of a two-dimensional array of integers in the range 0-255 and
 * The matrix represents a two-dimensional image in black and white,   
 * with the numbers representing the grayscale in image 0 being white and 255 being black.
 * @author Jose Bezerra
 * @version 19.04.2019
 */
public class MatrixSolution
{
   private int[][] _array;
   
   private static final int MAX_PIXEL = 255;
   /**
     *  Contructs a Matrix from a two dimensional array giving the Matrix the same
     *  dimensions and values of the two dimensional array,
     */
   public MatrixSolution(int size1, int size2)
   {
        _array = new int[size1][size2];    
   }
   
   /**
    * Contructor from a two-dimensional array
    */
   public MatrixSolution(int[][] array)
   {
        _array = new int[array.length][array[0].length];
        for (int i=0; i<array.length; i++)
            for (int j=0; j < array[0].length; j++)
                _array[i][j] = array[i][j];
   }
   
   /**
    * return a string representation of this Matrix
    */
   public String toString()
   {
       String res = "";
       for (int i=0; i<_array.length; i++)
       {
            for (int j=0; j < _array[0].length-1; j++)
                res += _array[i][j] + "\t";
            res += _array[i][_array[0].length-1] + "\n";
       }
       return res;
   }
   
   /**
    * Return the negative image of this matrix
    */
   public MatrixSolution makeNegative()
   {
	   MatrixSolution neg = new MatrixSolution(_array);
       for (int i=0; i<_array.length; i++)
            for (int j=0; j<_array[0].length; j++)
                neg._array[i][j] = MAX_PIXEL - neg._array[i][j];
       return neg;
   }
    
   /**
    * Smooth this image using an average filter
    */
   public MatrixSolution imageFilterAverage() 
   {
	   MatrixSolution smooth = new MatrixSolution(_array); 
       
       for (int i=0; i<_array.length; i++)
       {
            for (int j=0; j<_array[0].length; j++)
            {
                smooth._array[i][j] = getSmoothVal(i,j);
            }
        }
       return smooth; 
   }
   
	
	/**
	 * rotate Clockwise
	 * @return new Matrix with rotate clockwise array
	 */
	public MatrixSolution rotateClockwise() {
		int rows = _array.length;
		int columns = _array[0].length;
		int [][] mat = new int [columns][rows];
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				mat[i][j] = _array[rows-1-j][i];				
			}
		}
		return new MatrixSolution(mat);		
	} 
	
	/**
	 * rotate Counter Clockwise
	 * @return new Matrix with rotate clockwise array
	 */
	public MatrixSolution rotateCounterClockwise() {
		int rows = _array.length;
		int columns = _array[0].length;
		int [][] mat = new int [columns][rows];
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				mat[i][j] = _array[j][columns-1-i];				
			}
		}
		return new MatrixSolution(mat);
	}


   
   /**
    * Get the average value
    */
   private int getSmoothVal(int i, int j)
   {
        int counter = 0;
        int sum = 0;
        for (int i1 = i-1; i1<=i+1; i1++)
        {
            for (int j1 = j-1; j1<=j+1; j1++)
            {
                if (i1>=0 && i1<_array.length && j1>=0 && j1< _array[0].length)
                {
                    counter++;
                    sum += _array[i1][j1];
                }
            }
        }
        return sum/counter;
   }
}
