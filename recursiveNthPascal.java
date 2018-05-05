import java.util.*;

/* recursiveNthPascal program creates a pascal
*  triangle based upon the int "N" entry from 
*  the user, the "N" value represents the number
*  of lines the Nth pascal triangle is constructed
*  for.  The Nth pascal triangle is constructed
*  using a recursive set of functions, calling back
*  to itself  
*  
*  @author [Thomas Johnson]
*  @programName [recursiveNthPascal.java]
*/

public class recursiveNthPascal 
{
	//static int and int array variables 
	//used in this class
	static int N;
	static int arrayList[] = new int[0];
	static int n;
	static int level;
	
	/* static void calculatePascal function, which creates
	 * the Nth pascal triangle for display to the user.
	 * this method employs recursive functions in order
	 * to use new instances of itself to develop new lines
	 * for the pascal triangle up to the Nth line.
	 * 
	 * @param int arrayList[]
	 * @param int currentLine, int nthLine
	 * 
	 * @return void
	 */
	
	static void calculatePascal (int arrayList[], int currentLine, int nthLine)
	{
		int recursiveArray[] = new int[arrayList.length + 1];
		recursiveArray[0] = 1;
		
		for (int i = 1; i < arrayList.length; i++)
		{
			recursiveArray[i] = arrayList[i-1] + arrayList[i];
		}
		recursiveArray[recursiveArray.length - 1] = 1;
		
		//width adjustments for differing levels of pascal triangle
		level++;
		if((level == 6 || level == 10) && n > 0)
		{
			n--;
		}
		if(level == 11 && n > 0)
		{
			n-=2;
		}
		if((level == 12 || level == 13) && n > 0)
		{
			n--;
		}
		if((level >= 14 && level < 21) && n > 0)
		{
			n-=2;
		}
		if(level >= 21)
		{
			n-=4;
		}
        
		//char array based on "n" to indent each line
		char[] spaces = new char[n];
		Arrays.fill(spaces, ' ');
		System.out.print(spaces);
		n--;
		
		
		for(int i = 0; i < recursiveArray.length; i++)
		{
			System.out.print(recursiveArray[i] + " ");
		}
		System.out.println();
		
		if(recursiveArray.length < currentLine)
		{
			calculatePascal(recursiveArray, currentLine, nthLine);
		}
	}
	/* main method for accepting integer N input
	 * which is then used to call the "calculatePascal" 
	 * method, after which the "calculatePascal" results 
	 * are displayed.
	 * Integer inputs are restricted to ensure int entry
	 * and that the entry is greater than zero.
	 */
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		boolean invalidCheck = false;
		System.out.println("Enter an integer number to display the lines of a pascal triangle up to: ");
		
		while(!in.hasNextInt())
		{
			System.out.println("Invalid Entry");
			System.out.println("Please enter an integer value: ");
			in.next();
		}
		N = in.nextInt();
		while(N <= 0)
		{
			System.out.println("Invalid Entry");
			System.out.println("Please enter an integer value greater than zero: ");
			in.next();
			invalidCheck = true;
		}
		if(invalidCheck)
		{
			N = in.nextInt();
		}
		in.close();
		//calculation of the "n" variable used for formatting
		n = N*3;
		calculatePascal(arrayList, N, N);
	}
}
