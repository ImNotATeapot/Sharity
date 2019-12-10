package itp341.piyawiroj.patriya.sharity.models;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BusinessHour {

    private String day;
    private LocalTime from;
    private LocalTime to;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }
}
