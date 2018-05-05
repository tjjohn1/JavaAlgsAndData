import java.util.Scanner;

public class detectPalindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input;
        String inputString;
        System.out.println("Enter a String to check for palindrome-ness: ");

        input = sc.nextLine();
        inputString = input.replaceAll("\\s+","");;
        while(inputString.length() <= 2){
            System.out.println("Input must be at least 3 non-whitespace characters long,\nplease re-enter string, also enter X or x to exit");
            input = sc.nextLine();
            inputString = input.trim();
            if(inputString.equalsIgnoreCase("X")){
                break;
            }
        }
        sc.close();
        if(!inputString.equalsIgnoreCase("X")){
            int j = inputString.length() - 1;
            for (int i = 0; i < inputString.length(); i++) {
                if(j < i){
                    System.out.println("Is a Palindrome");
                    break;
                }
                char left = inputString.charAt(i);
                char right = inputString.charAt(j);
                //System.out.println("Comparing " + left + " at position " + i + " to " + right + " at position " + j);
                if(left == right){
                    j--;
                } else {
                    System.out.println("Not a Palindrome");
                    break;
                }
            }
        }
    }
}
