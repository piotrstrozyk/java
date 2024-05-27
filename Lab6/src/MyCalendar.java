import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;
public class MyCalendar {
    private ArrayList<Event>[] week = new ArrayList[7];
    public MyCalendar(){
        this(7);
    };
    public MyCalendar(int days){
        for(int day = 0; day < days; day++){
            week[day] = new ArrayList<Event>();
        }
    }
    public void addEvent(int day, Meeting meeting) {
        week[day + 1].add(meeting);
    }
    public void addEvent(int day, Task task) {
        week[day + 1].add(task);
    }
    public void deleteEvent(int day, int index, Predicate<Event> condition) {
        ArrayList<Event> events = filterEvents(day, condition);
        if (index >= 0 && index < events.size()) {
            week[day].remove(events.get(index));
        }
    }
    public ArrayList<Event> filterEvents(int day, Predicate<Event> condition) {
        ArrayList<Event> events = new ArrayList<>();
        for (Event event : week[day]) {
            if (condition.test(event)) {
                events.add(event);
            }
        }
        return events;
    }
}


