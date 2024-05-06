import java.time.LocalTime;
public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Priority priority;

    public enum Priority {
        normal, high, highest
    };
    public static final LocalTime MIN_TIME = LocalTime.of(6, 0);

    public Meeting(String description, LocalTime startTime, LocalTime endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = Priority.valueOf(priority);
    }
    public Priority getPriority() {
        return this.priority;
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
    public String toString(){
            return (
                    "  Description: " + '"' + this.description + '"' +
                    "  Start time: " + this.startTime +
                    "  End Time: " + this.endTime +
                    "  Priority: " + this.priority
                    );
        }
}