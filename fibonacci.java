import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci {

    static String generateFibonacci(int n){
        switch(n) {
            case 0:
                return "1";
            case 1:
                return "1, 1";
            default:
                BigInteger first = BigInteger.ONE;
                BigInteger second = BigInteger.ONE;
                BigInteger fibonacci;
                StringBuilder returnString = new StringBuilder("1, 1, ");
                for(int i = 2; i <= n; i++){
                    fibonacci = first.add(second);
                    first = second;
                    second = fibonacci;
                    returnString.append(fibonacci);
                    if(i < n){
                        returnString.append(", ");
                    }
                }
                return returnString.toString();
        }

    }

    public static void main(String[]args) {
        int n;
        Scanner in = new Scanner(System.in);
        boolean invalidCheck = false;
        System.out.println("Enter an integer number to display the fibonacci sequence for: ");

        while(!in.hasNextInt())
        {
            System.out.println("Invalid Entry");
            System.out.println("Please enter an integer value: ");
            in.next();
        }
        n = in.nextInt();
        while(n < 0)
        {
            System.out.println("Invalid Entry");
            System.out.println("Please enter an integer value greater than -1: ");
            in.next();
            invalidCheck = true;
        }
        if(invalidCheck)
        {
            n = in.nextInt();
        }
        in.close();
        System.out.println("Fibonacci Sequence for " + n + ":\n" + generateFibonacci(n));
    }
}
