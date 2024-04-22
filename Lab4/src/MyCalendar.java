import java.time.LocalTime;
import java.util.ArrayList;
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
    public Meeting getMeeting(int day, int index) {
        return week[day].get(index);
    }
    public ArrayList<Meeting> getMeetingsForDay(int day){
        return week[day];
    }
    public ArrayList<Meeting> getMeetingsOfPriority(int day, String priority){
        ArrayList<Meeting> ofPriority = new ArrayList<Meeting>();
        for(int i = 0; i < week[day].size(); i++){
            if(week[day].get(i).getPriority().equals(Meeting.Priority.valueOf(priority))){
                ofPriority.add(week[day].get(i));
            }
        }
        return ofPriority;
    }
    public ArrayList<Meeting> getMeetingsPastTime(int day, LocalTime time){
        ArrayList<Meeting> pastTime = new ArrayList<Meeting>();
        for(int i = 0; i < week[day].size(); i++){
            if(week[day].get(i).getStartTime().isAfter(time)){
                pastTime.add(week[day].get(i));
            }
        }
        return pastTime;
    };
}

