import java.time.LocalDateTime;

// We implemented this class since it is not implemented in standard Java. In other languages it could be imported
// as complete class. This is just a mock. Hence we did not showed it in the UML class diagram.
public class TimePeriod {
    LocalDateTime start;
    LocalDateTime end;

    public TimePeriod() {
        start = LocalDateTime.now();
        end = LocalDateTime.now().plusHours(2);
    }

    public TimePeriod(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public TimePeriod(TimePeriod timePeriod) {

    }
}
