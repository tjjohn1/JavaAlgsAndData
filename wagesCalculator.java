import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class wagesCalculator {

    public static void main(String[]args) {
        int hours = 0;
        double rate = 0;
        Scanner sc = new Scanner(System.in);
        boolean invalidCheck = false;
        System.out.println("Enter amount of hours worked in the two week period ");

        while (!invalidCheck) {
            String line = sc.nextLine();
            try {
                hours = Integer.parseInt(line);
                if (hours >= 0 && hours <= 336) {
                    invalidCheck = true;
                } else if (hours < 0){
                    System.out.println("Input must be a positive integer equal or greater than zero, please re-enter.\n");
                } else if (hours > 336){
                    System.out.println("Input must be less than possible hours in two week period, please re-enter.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a positive integer greater than zero, please re-enter.\n");
            }
        }

        invalidCheck = false;
        System.out.println("Enter pay rate ");

        while (!invalidCheck) {
            String line = sc.nextLine();
            try {
                rate = Math.round(Double.parseDouble(line) * 100D) / 100D;
                if (rate >= 1) {
                    invalidCheck = true;
                } else if (rate < 1){
                    System.out.println("Input must be a positive double equal or greater than 1.00, please re-enter.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a positive double greater than 1.00, please re-enter.\n");
            }
        }

        double wages = calculatePay(hours, rate);
        System.out.println("Total Wages for " + hours + " hours @$" + rate + "/hour: $" + wages);
    }

    private static double calculatePay(int hours, double rate){
        double wages = 0;
        if(hours <= 40){
            wages = hours * rate;
        } else {
            wages = 40 * rate;
            int overtime = hours - 40;
            wages += overtime * (1.5 * rate);
        }
        return Math.round(wages * 100D) / 100D;
    }
}
