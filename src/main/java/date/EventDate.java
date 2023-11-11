package date;

import java.time.LocalDate;

public enum EventDate {
    CHRISTMAS_DDAY("????? ??? ??", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25)),
    WEEKDAY_DISCOUNT("?? ??", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    WEEKEND_DISCOUNT("?? ??", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    SPECIAL_DISCOUNT("?? ??", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31)),
    GIFT_EVENT("?? ???", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31));

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    EventDate(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

}
