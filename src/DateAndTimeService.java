import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeService {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    // pole statyczne jest współdzielone przez wszystkie instancje, format jest tylko jeden oraz
    private int timeIntervalInMiliseconds = 5*60*1000;
//minuty, private static final i DUZYMI

    public int getTimeIntervalInMiliseconds() {
        return timeIntervalInMiliseconds;
    }

    public static void displayLocalDateAndTime() {
        System.out.println(FORMAT.format(new Date()));
    }
    //tutaj nie ma juz konstruktora FORMAT
}
