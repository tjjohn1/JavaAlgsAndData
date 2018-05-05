import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class reverseIntMath {
    public static void main(String[]args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean invalidCheck = false;
        System.out.println("Enter an integer to reverse: ");

        while (!invalidCheck) {
            String line = sc.nextLine();
            try {
                n = Integer.parseInt(line);
                invalidCheck = true;
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer, please re-enter.\n");
                invalidCheck = false;
            }
        }
        System.out.println("Input Integer: " + n);
        int reversed = reverseInt(n);
        System.out.println("Reversed Integer: " + reversed);
    }

    private static int reverseInt(int n){
        int reversed = 0;
        int remainder = 0;
        while(n != 0) {
            remainder = n % 10;
            n = (n - remainder) / 10;
            reversed = (reversed * 10) + remainder;
        }
        return reversed;
    }
}
