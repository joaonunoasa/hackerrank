import java.util.Scanner;

/**
 * Created by joaosa on 23/04/17.
 */
public class Solution {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String time = in.next();

        String[] splitString = time.split(":");

        String amOrPm = splitString[2];

        if (amOrPm.contains("AM")) {
            if (splitString[0].equals("12")) {
                System.out.println("00:"+splitString[1]+":"+amOrPm.substring(0,2));
            } else {
                System.out.println(time.substring(0, 8));
            }
        } else {
            int hour = Integer.parseInt(splitString[0]) + 12;
            if (hour == 24) {
                System.out.println("12" + ":" + splitString[1] + ":" + amOrPm.substring(0, 2));
            } else {
                System.out.println(hour + ":" + splitString[1] + ":" + amOrPm.substring(0, 2));
            }
        }


    }
}
