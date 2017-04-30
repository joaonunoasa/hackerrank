import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int height[] = new int[n];
        int biggestHeight = 0;
        for (int height_i = 0; height_i < n; height_i++) {
            height[height_i] = in.nextInt();
            if (height[height_i] > biggestHeight)
                biggestHeight = height[height_i];
        }

        int blowedCandles = 0;
        for (int height_i = 0; height_i < n; height_i++) {
            if (height[height_i] == biggestHeight)
                blowedCandles++;
        }

        System.out.println(blowedCandles);
    }
}
