import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wordCount {
    public static void main(String args[]) throws FileNotFoundException{
        List<String> words = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String input;
        String inputString;
        System.out.println("Enter a path of a file to count words from in the format\n" +
                "C:\\parent\\child\\file.txt: ");

        input = sc.nextLine();
        inputString = input.trim();

        while (inputString.length() < 3) {
            System.out.println("Input path characters long,\nplease re-enter string, also enter X or x to exit");
            input = sc.nextLine();
            inputString = input.trim();
            if (inputString.equalsIgnoreCase("X")) {
                break;
            }
        }
        sc.close();
        if (!inputString.equalsIgnoreCase("X")) {
            try {
                Scanner fileRead = new Scanner(new File(inputString));
                while (fileRead.hasNext()) {
                    String word = fileRead.next();
                    words.add(word);
                }
            } catch (FileNotFoundException e){
                System.out.println("Path or file is invalid");
            }
        }
        System.out.println("Number of words in: " + inputString + " is " + words.size());
        //for(String element:words){
            //System.out.print(element + " ");
        //}
        //System.out.println("");
    }
}
