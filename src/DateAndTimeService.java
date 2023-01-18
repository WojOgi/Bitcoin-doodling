import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeService {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private double timeIntervalInMinutes = 1;

    public void setTimeIntervalInMinutes(double timeIntervalInMinutes) {
        this.timeIntervalInMinutes = timeIntervalInMinutes;
    }

    public double getTimeIntervalInMinutes() {
        return timeIntervalInMinutes;
    }

    public static void displayLocalDateAndTime() {
        System.out.println(FORMAT.format(new Date()));
    }
}
