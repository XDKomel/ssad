import java.time.LocalDateTime;

public class Table {
    private int ID;
    private TimePeriod bookedPeriod;

    public int getID() {
        return this.ID;
    }

    public TimePeriod getBookedPeriod() {
        return new TimePeriod(this.bookedPeriod);
    }

    public boolean isBusy(TimePeriod timePeriod) {
        LocalDateTime start = timePeriod.start;
        LocalDateTime end = timePeriod.end;
        return start.isAfter(bookedPeriod.start) && start.isBefore(bookedPeriod.end) ||
                end.isAfter(bookedPeriod.start) && end.isBefore(bookedPeriod.end) ||
                end.isAfter(bookedPeriod.end) && start.isBefore(bookedPeriod.start);
    }

    public Table(int ID, TimePeriod bookedPeriod) {
        this.ID = ID;
        this.bookedPeriod = bookedPeriod;
    }

    public Table(Table table) {
        ID = table.getID();
        bookedPeriod = new TimePeriod(table.getBookedPeriod());
    }
}