import java.util.*;

public class combineSortedArrays {

    public static void main(String[]args) {
        int[] intArray1 = countSort(getArray());
        int[] intArray2 = countSort(getArray());
        int length1 = intArray1.length;
        int length2 = intArray2.length;

        /*
        Set<Integer> integersSorted = new HashSet<Integer>(){
            public int compare(Integer i1, Integer i2) {
                if(i1 > i2){
                    return 1;
                } else {
                    return -1;
                }
            }

            public boolean equals(Object o) {return true;}
        };
        */

        int length = Math.max(length1, length2);
        int[] unsortedIntArray = new int[length1 + length2];

        int j = 0;
        for(int i = 0; i < length; i++){
            if(i < length1){
                unsortedIntArray[j] = (intArray1[i]);
                j++;
            }
            if(i < length2){
                unsortedIntArray[j] = (intArray2[i]);
                j++;
            }
        }

        /*
        int[] finalIntArray = integersSorted.stream().mapToInt(Integer::intValue).toArray();
        */

        int[] finalIntArray = countSort(unsortedIntArray);

        System.out.println("FinalArray: ");
        for(int element:finalIntArray){
            System.out.print(element + " ");
        }
        System.out.println("");

    }

    private static int[] getArray(){
        System.out.println("Enter an integer list separated by spaces, to sort and combine: ");
        Scanner sc = new Scanner(System.in);
        boolean invalidEntry = false;
        String scannerInput;
        String inputString;
        scannerInput = sc.nextLine();
        inputString = scannerInput.trim();
        String[] inputs = inputString.split(" ");
        int length = inputs.length;
        int[] intInputs = new int[length];
        for(int i = 0; i < length; i++){
            try{
                intInputs[i] = Integer.parseInt(inputs[i]);
                invalidEntry = true;
            } catch (NumberFormatException e) {
                invalidEntry = false;
            }
        }
        while (length < 1 || !invalidEntry) {
            System.out.println("Input must be at least 1 integer value,\nplease re-enter list of integer(s) separated by spaces,\nalso enter X or x to exit");
            scannerInput = sc.nextLine();
            inputString = scannerInput.trim();
            if(inputString.equalsIgnoreCase("X")){
                break;
            } else {
                inputs = inputString.split(" ");
                length = inputs.length;
                intInputs = new int[length];
                for(int i = 0; i < length; i++){
                    try{
                        intInputs[i] = Integer.parseInt(inputs[i]);
                        invalidEntry = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be all integers,\nplease re-enter list of integers separated by spaces,\nalso enter X or x to exit");
                        invalidEntry = false;
                    }
                }
            }
        }
        return intInputs;
    }

    private static int findMax(int[] array){
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }

        }

        return max;
    }

    private static int[] countSort(int[] array){
        int max = findMax(array);
        int counts[] = new int[max + 1];
        //System.out.println("countsLength: " + counts.length);
        for(int number : array){
            //System.out.println("number: " + number);
            if(number >= 0){
                counts[number]++;
            }
        }

        int[] array_sorted = new int[array.length];
        int index = 0;

        for(int i = 0; i < counts.length; i++) {
            int count = counts[i];

            for(int j = 0; j < count; j++){
                array_sorted[index] = i;
                index++;
            }
        }

        return array_sorted;

    }
}
