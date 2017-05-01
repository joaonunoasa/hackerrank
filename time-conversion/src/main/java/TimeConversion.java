/**
 * Created by joaosa on 01/05/17.
 */
public class TimeConversion {

    private final String time;

    public TimeConversion(String time) {
        this.time = time;
    }

    public String convert() {

        String[] splitString = time.split(":");

        String amOrPm = splitString[2];

        String result;

        if (amOrPm.contains("AM")) {
            if (splitString[0].equals("12")) {
                result = "00:"+splitString[1]+":"+amOrPm.substring(0,2);
            } else {
                result = time.substring(0, 8);
            }
        } else {
            int hour = Integer.parseInt(splitString[0]) + 12;
            if (hour == 24) {
                result = "12" + ":" + splitString[1] + ":" + amOrPm.substring(0, 2);
            } else {
                result = hour + ":" + splitString[1] + ":" + amOrPm.substring(0, 2);
            }
        }

        return result;

    }
}
