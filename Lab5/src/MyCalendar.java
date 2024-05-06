import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;
public class MyCalendar {
    private ArrayList<Meeting>[] week = new ArrayList[7];
    public MyCalendar(){
        this(7);
    };
    public MyCalendar(int days){
        for(int day = 0; day < days; day++){
            week[day] = new ArrayList<Meeting>();
        }
    }
    public void addMeeting(int day, String description, LocalTime startTime, LocalTime endTime, String priority){
        week[day + 1].add(new Meeting(description, startTime, endTime, priority));
    }
    public void deleteMeeting(int day, int index){
        week[day].remove(index);
    }
    public ArrayList<Meeting> filterMeetings(int day, Predicate<Meeting> condition) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (Meeting meeting : week[day]) {
            if (condition.test(meeting)) {
                meetings.add(meeting);
            }
        }
        return meetings;
    }
}


