import java.time.LocalTime;
public abstract sealed class Event permits Task, Meeting {
    protected String description;
    protected LocalTime startTime;
    protected LocalTime endTime;
    public Event(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public String getDescription() {
        return description;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public String getPriority() {
        return null;
    }
    @Override
    public String toString() {
        return "Description: " + description +
                ", Start time: " + startTime +
                ", End time: " + endTime;
    }
}
