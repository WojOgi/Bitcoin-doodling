import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeService {

    private int timeIntervalInMiliseconds = 2*60*1000;



    public int getTimeIntervalInMiliseconds() {
        return timeIntervalInMiliseconds;
    }

    public void setTimeIntervalInMiliseconds(int timeIntervalInMiliseconds) {
        this.timeIntervalInMiliseconds = timeIntervalInMiliseconds;
    }


    public static void displayLocalDateAndTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
    }
}
