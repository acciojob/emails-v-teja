package com.driver;

import java.time.LocalTime;

public class Meeting {
    private LocalTime startTime;

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
