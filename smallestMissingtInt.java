import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class smallestMissingtInt {

    public static void main(String[]args) {
        int[] array = getArray();
        int missing = findMinMissing(array);
        System.out.println("Minimum missing Integer: " + missing);
    }

    public static int findMinMissing(int[] A) {
        if (A.length > 0) {
            int A_max = findMax(A);
            if (A_max > 0) {
                int[] A_sorted = countSort(A, A_max);
                int N = findMissing(A_sorted);
                return N;
            } else {
                return 1;
            }
        } else return 1;
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

    private static int[] countSort(int[] array, int max){
        int counts[] = new int[max + 1];
        //System.out.println("countsLength: " + counts.length);
        for(int number : array){
            //System.out.println("number: " + number);
            if(number > 0){
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

    private static int findMissing (int[] array){
        int missing = 1;
        for(int i = 0; i < array.length; i++){
            //System.out.println("Array[i]: " + array[i]);
            //System.out.println("Current_missing: " + missing);
            if(array[i] >= 0){
                if(missing == array[i]){
                    missing++;
                }
            }
        }
        return missing;
    }

    private static int[] getArray(){
        System.out.println("Enter an integer list separated by spaces, to find smallest missing Integer: ");
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
}
