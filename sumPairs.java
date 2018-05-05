import java.util.*;

public class sumPairs {
    public static void main(String[]args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean invalidCheck = false;
        System.out.println("Enter an integer sum to find pairs for: ");

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

        System.out.println("Enter an integer list separated by spaces, to check sum pairs for: ");

        invalidCheck = false;
        String input;
        String inputString;
        input = sc.nextLine();
        inputString = input.trim();
        String[] inputs = inputString.split(" ");
        int length = inputs.length;
        int[] intInputs = new int[length];
        for(int i = 0; i < length; i++){
            try{
                intInputs[i] = Integer.parseInt(inputs[i]);
                invalidCheck = true;
            } catch (NumberFormatException e) {
                invalidCheck = false;
            }
        }
        while (length < 2 || !invalidCheck) {
            System.out.println("Input must be at least 2 integer values,\nplease re-enter list of integers separated by spaces,\nalso enter X or x to exit");
            input = sc.nextLine();
            inputString = input.trim();
            if(inputString.equalsIgnoreCase("X")){
                break;
            } else {
                inputs = inputString.split(" ");
                length = inputs.length;
                intInputs = new int[length];
                for(int i = 0; i < length; i++){
                    try{
                        intInputs[i] = Integer.parseInt(inputs[i]);
                        invalidCheck = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be all integers,\nplease re-enter list of integers separated by spaces,\nalso enter X or x to exit");
                        invalidCheck = false;
                    }
                }
            }
        }

        sc.close();
        HashMap<Integer, Integer> pairsMap = findPairs(n, intInputs);
        int size = pairsMap.size();
        System.out.println("Number of pairs found: " + size);
        if(size > 0){
            for (Map.Entry<Integer, Integer> entry : pairsMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                System.out.print("(" + key + ", " + value + ") ");
            }
        }
        System.out.println("");
    }

    private static HashMap findPairs(int sum, int[] array){
        HashMap<Integer, Integer> pairsMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> singlesMap = new HashMap<Integer, Integer>();

        for(int element:array){
            if(!singlesMap.containsKey(element)){
                singlesMap.put(element, 0);
            }
            singlesMap.put(element, singlesMap.get(element) + 1);
        }

        for(int i = 0; i < array.length; i++) {
            int diff = sum - array[i];
            //System.out.println("diff: " + diff + ", int: " + array[i]);
            if (pairsMap.containsKey(array[i])) {
                System.out.println("Pairs Contains: " + array[i] + " with value " + pairsMap.get(array[i]));
                System.out.println("Singles Contains: " + diff + " with value " + singlesMap.get(diff));
                if (pairsMap.get(array[i]) == diff && singlesMap.get(array[i]) == 1) {
                    System.out.println("Removing: " + diff + ", " + pairsMap.get(array[i]));
                    pairsMap.remove(array[i]);
                }
            }
            if (singlesMap.containsKey(diff)) {
                pairsMap.put(diff, array[i]);
            }
        }
        return pairsMap;
    }
}
