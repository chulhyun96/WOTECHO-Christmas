package date;

import java.time.LocalDate;

public enum EventDate {
    EVENT_START(LocalDate.of(2023, 12, 1)),
    EVENT_END(LocalDate.of(2023, 12, 31)),
    CHRISTMAS_START(LocalDate.of(2023, 12, 1)),
    CHRISTMAS_END(LocalDate.of(2023, 12, 25));
    private final LocalDate date;
    EventDate(LocalDate date) {
        this.date = date;
    }
    public LocalDate getDate() {
        return date;
    }
}
