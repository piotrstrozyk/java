import java.io.ObjectInputFilter.Status;
import java.time.LocalTime;
public final class Task extends Event {
    private TaskStatus status;
    public static final LocalTime MIN_TIME = LocalTime.of(6, 0);
    enum TaskStatus {
        planned, confirmed, inProgress, completed
    }
    public Task(String description, LocalTime startTime, LocalTime endTime, String status) {
        super(description, startTime, endTime);
        this.status = TaskStatus.valueOf(status);
    }
    public TaskStatus getStatus() {
        return this.status;
    }
    @Override
    public String toString(){
        return (
                "  Description: " + '"' + this.description + '"' +
                        "  Start time: " + this.startTime +
                        "  End Time: " + this.endTime +
                        "  Status: " + this.status
        );
    }
}
