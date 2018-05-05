import java.util.Scanner;

public class hollowCube {

    public static void main(String[]args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        boolean invalidCheck = false;
        System.out.println("Enter an integer number greater than 2, to display\nnumber of blocks needed for a hollow cube of n size: ");

        while (!invalidCheck) {
            String line = sc.nextLine();
            try {
                n = Integer.parseInt(line);
                if (n >= 3) {
                    invalidCheck = true;
                } else {
                    System.out.println("Input must be a positive integer greater than 2,\nhollow cube not possible with less than 3x3 cube\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a positive integer greater than 2,\nhollow cube not possible with less than 3x3 cube\n");
            }
        }
        sc.close();
        int[] blocks = calculateBlocks(n);
        System.out.println("Number of 1x1 blocks needed for hollow cubes of " + n + " size:");
        System.out.println("Cube with inside hollow, all solid faces: " + blocks[0]);
        System.out.println("Cubic tube, two open faces: " + blocks[1]);
        System.out.println("Cubic frame, all open faces: " + blocks[2]);
    }

    private static int[] calculateBlocks(int n){
        int blocks[] = new int[3];

        int largeFace = n * n;
        //System.out.println("Large Face Area: " + largeFace);

        int mediumFace = (n-2) * (n);
        //System.out.println("Medium Face Area: " + mediumFace);

        int smallFace = (n-2) * (n-2);
        //System.out.println("Small Face Area: " + smallFace);

        blocks[0] = (2 * largeFace) + (2 * smallFace) + (2 * mediumFace);
        blocks[1] = (2 * largeFace) + (2 * mediumFace);
        blocks[2] = blocks[1] - (4 * smallFace);

        return blocks;
    }
}
