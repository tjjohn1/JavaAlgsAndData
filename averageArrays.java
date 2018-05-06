import java.util.Arrays;
import java.util.Scanner;

public class averageArrays {

    public static void main(String[]args) {
        double[] doubleArray1 = getArray();
        double[] doubleArray2 = getArray();
        double average = calculateAverages(doubleArray1, doubleArray2);
        System.out.println("Average of entered arrays: " + average);
    }

    public static double calculateAverages(double[] array1, double[] array2) {

        double result1 = 0;
        double result2 = 0;
        double result = 0;

        for(int i = 0; i< array1.length; i++) {
            result1 = Arrays.stream(new double[]{array1[i]}).average().getAsDouble();
        }
        for(int i = 0; i< array2.length; i++) {
            result2 = Arrays.stream(new double[]{array2[i]}).average().getAsDouble();
        }

        result = (result1 + result2) / 2;

        return result;
    }

    /* Future implementation for variable number of double array inputs
    public static double[] averages(double[]... input) {

        double[] result = new double[input.length];

        for(int i = 0; i< result.length; i++) {
            result[i] = Arrays.stream(input[i]).average().getAsDouble();
        }

        return result;
    }
    */

    private static double[] getArray(){
        System.out.println("Enter an double list separated by spaces, to get averages for: ");
        Scanner sc = new Scanner(System.in);
        boolean invalidEntry = false;
        String scannerInput;
        String inputString;
        scannerInput = sc.nextLine();
        inputString = scannerInput.trim();
        String[] inputs = inputString.split(" ");
        int length = inputs.length;
        double[] doubleInputs = new double[length];
        for(int i = 0; i < length; i++){
            try{
                doubleInputs[i] = Double.parseDouble(inputs[i]);
                invalidEntry = true;
            } catch (NumberFormatException e) {
                invalidEntry = false;
            }
        }
        while (length < 1 || !invalidEntry) {
            System.out.println("Input must be at least 1 double value,\nplease re-enter list of doubles(s) separated by spaces,\nalso enter X or x to exit");
            scannerInput = sc.nextLine();
            inputString = scannerInput.trim();
            if(inputString.equalsIgnoreCase("X")){
                break;
            } else {
                inputs = inputString.split(" ");
                length = inputs.length;
                doubleInputs = new double[length];
                for(int i = 0; i < length; i++){
                    try{
                        doubleInputs[i] = Double.parseDouble(inputs[i]);
                        invalidEntry = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be all integers,\nplease re-enter list of integers separated by spaces,\nalso enter X or x to exit");
                        invalidEntry = false;
                    }
                }
            }
        }
        return doubleInputs;
    }
}
