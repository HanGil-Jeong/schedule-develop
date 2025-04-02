package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String writerUsername;

    private final String scheduleTitle;

    private final String schedeuleContents;

    public ScheduleResponseDto(Long id, String writerUsername, String scheduleTitle, String schedeuleContents) {
        this.id = id;
        this.writerUsername = writerUsername;
        this.scheduleTitle = scheduleTitle;
        this.schedeuleContents = schedeuleContents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getWriterUsername(), schedule.getScheduleTitle(), schedule.getScheduleContents());
    }
}
