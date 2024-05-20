import java.time.LocalTime;
public final class Meeting extends Event {
    private Priority priority;
    public enum Priority {
        normal, high, highest
    };
    public static final LocalTime MIN_TIME = LocalTime.of(6, 0);

    public Meeting(String description, LocalTime startTime, LocalTime endTime, String priority) {
        super(description, startTime, endTime);
        this.priority = Priority.valueOf(priority);
    }
    public LocalTime getStartTime() {
        return this.startTime;
    }
    public String getDescription() {
        return this.description;
    }
    public LocalTime getEndTime() {
        return this.endTime;
    }
    @Override
    public String getPriority() {
        return this.priority.toString();
    }
    @Override
    public String toString() {
        return super.toString() + ", Priority: " + getPriority() + getDescription();
    }
}