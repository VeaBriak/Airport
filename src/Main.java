import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import java.util.*;

/**Используя библиотеку airport.jar, распечатать время вылета и модели самолётов, вылетающие в ближайшие 2 часа.**/

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        Date afterDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, 2);
        Date beforeDate = cal.getTime();

        System.out.println("Расписание рейсов, вылетающих в ближайшие два часа:");
        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .forEach(Flight -> Flight.stream()
                        .filter(s -> s.getDate().after(afterDate) && s.getDate().before(beforeDate))
                        .filter(o -> o.getType() == com.skillbox.airport.Flight.Type.DEPARTURE)
                        .forEach(System.out::println)
                );

    }
}






