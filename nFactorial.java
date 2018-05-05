import java.math.BigInteger;
import java.util.Scanner;

public class nFactorial {

    public static void main(String[]args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean invalidCheck = false;
        System.out.println("Enter an integer number to display the n factorial for: ");

        while (!invalidCheck) {
            String line = sc.nextLine();
            try {
                n = Integer.parseInt(line);
                if (n > 0) {
                    invalidCheck = true;
                } else {
                    System.out.print("Input must be a positive integer greater than zero, please re-enter.\n");
                }
            } catch (NumberFormatException e) {
                System.out.print("Input must be a positive integer greater than zero, please re-enter.\n");
            }
        }
        sc.close();
        System.out.println("n Factorial for " + n + ":\n" + calculateFactorial(n));
    }

    private static BigInteger calculateFactorial(int n){
        BigInteger N = BigInteger.valueOf(n);
        if(n == 1){
            N = BigInteger.ONE;
        } else {
            for(int i = n; i > 1; i--){
                N = N.multiply(BigInteger.valueOf(i-1));
            }
        }
        return N;
    }


}

