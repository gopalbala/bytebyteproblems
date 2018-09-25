package general;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by gbalasubramanian on 23/11/17.
 */
public class ClockAngle {
    public static void main(String[] args) {
        double degreesPerminute = 360 / 60;
        double degreesPerHour = 360 / 12;
        double minutesPerHour = 60;

        Scanner scanner = new Scanner(System.in);
        double hours = scanner.nextInt();
        double minutes = scanner.nextInt();
        double minuteAngle = minutes * degreesPerminute;
        double hourAngle = hours * degreesPerHour + (minutes/ minutesPerHour) * degreesPerHour;

        double diff = Math.abs(minuteAngle - hourAngle);
        if (diff > 180)
            System.out.println(360 - diff);
        else
            System.out.println(diff);

    }
}
