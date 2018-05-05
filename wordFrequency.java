import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class wordFrequency {
    public static void main(String[]args) {
        System.out.println("Enter a list of strings separated by spaces: ");
        Scanner sc = new Scanner(System.in);
        String input;
        String inputString;
        input = sc.nextLine();
        inputString = input.trim();
        while(inputString.length() == 0){
            System.out.println("Input must be at least 1 non-whitespace character long,\nplease re-enter list of strings separated by spaces,\nalso enter X or x to exit");
            input = sc.nextLine();
            inputString = input.trim();
            if(inputString.equalsIgnoreCase("X")){
                break;
            }
        }
        sc.close();
        if(!inputString.equalsIgnoreCase("X")) {
            String[] inputArray = inputString.split(" ");
            System.out.println("Entered Array: ");
            for (int i = 0; i < inputArray.length; i++) {
                if(inputArray[i].trim().length() != 0) {
                    switch (i) {
                        case 0:
                            System.out.print(inputArray[i]);
                            break;
                        default:
                            System.out.print(", " + inputArray[i]);
                            break;
                    }
                }
            }
            System.out.println("");
            String[][] returnArray = frequentString(inputArray);
            if(returnArray.length > 1) {
                if (returnArray[1][1] != null) {
                    System.out.println("\nTies for most frequent word are: ");
                    for (int i = 0; i < returnArray.length; i++) {
                        if (returnArray[i][0] == null) {
                            break;
                        }
                        switch (i) {
                            case 0:
                                System.out.print(returnArray[i][0]);
                                break;
                            default:
                                System.out.print(", " + returnArray[i][0]);
                                break;
                        }
                    }
                    System.out.println("\nWhich each occur " + returnArray[0][1] + " time(s)");
                } else {
                    System.out.println("\nMost frequent word is: " + returnArray[0][0] + ", which occurs " + returnArray[0][1] + " time(s)");
                }
            } else {
                System.out.println("\nMost frequent word is: " + returnArray[0][0] + ", which occurs 1 time");
            }
        }
    }

    private static String[][] frequentString(String[] array){
        Integer frequency = 1;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for(String word:array){
            if(word.trim().length() != 0){
                if(wordMap.containsKey(word)){
                    wordMap.put(word.trim(), wordMap.get(word) + 1);
                } else {
                    wordMap.put(word.trim(), 1);
                }
            }
        }

        String[][] returnArray = new String[wordMap.size()][2];

        Set<Map.Entry<String, Integer>> wordEntrySet = wordMap.entrySet();
        String word;
        int i = 0;
        for (Map.Entry<String, Integer> wordEntry : wordEntrySet)
        {
            if(wordEntry.getValue() == frequency)
            {
                word = wordEntry.getKey();
                frequency = wordEntry.getValue();
                //System.out.println("Frequent word tie found: " + word + " with freq of: " + frequency);
                returnArray[i][0] = word;
                returnArray[i][1] = String.valueOf(frequency);
                i++;
            } else if(wordEntry.getValue() > frequency)
            {
                word = wordEntry.getKey();
                frequency = wordEntry.getValue();
                //System.out.println("Frequent word found: " + word + " with freq of: " + frequency);
                returnArray[0][0] = word;
                returnArray[0][1] = String.valueOf(frequency);
                i = 1;
                returnArray[1][0] = null;
                returnArray[1][1] = null;
            }
        }
        return returnArray;
    }
}
