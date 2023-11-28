package date;

import java.time.LocalDate;

public enum Event {
    CHRISTMAS_DDAY(EventCategory.CHRISTMAS, EventDate.CHRISTMAS_START, EventDate.CHRISTMAS_END),
    WEEKDAY_DISCOUNT(EventCategory.WEEKDAY, EventDate.EVENT_START, EventDate.EVENT_END),
    WEEKEND_DISCOUNT(EventCategory.WEEKEND, EventDate.EVENT_START, EventDate.EVENT_END),
    SPECIAL_DISCOUNT(EventCategory.SPECIAL, EventDate.EVENT_START, EventDate.EVENT_END),
    GIFT_EVENT(EventCategory.GIFT, EventDate.EVENT_START, EventDate.EVENT_END);
    private final EventCategory name;
    private final EventDate startDate;
    private final EventDate endDate;
    Event(EventCategory name, EventDate startDate, EventDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public String getDisplayName() {
        return this.name.getEventName();
    }

    public LocalDate getStartDate() {
        return startDate.getDate();
    }

    public LocalDate getEndDate() {
        return endDate.getDate();
    }

}
