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
    public void addMeeting(int day, String description, LocalTime startTime, LocalTime endTime, String priority){
        week[day + 1].add(new Meeting(description, startTime, endTime, priority));
    }
    public void addTask(int day, String description, LocalTime startTime, LocalTime endTime, String status){
        week[day + 1].add(new Task(description, startTime, endTime, status));
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


