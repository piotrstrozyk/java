import java.time.LocalTime;
abstract sealed class Event permits Task, Meeting {
}
