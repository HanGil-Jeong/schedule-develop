package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String writerUsername;

    private final String scheduleTitle;

    private final String schedeuleContents;

    public CreateScheduleRequestDto(String writerUsername, String scheduleTitle, String schedeuleContents) {
        this.writerUsername = writerUsername;
        this.scheduleTitle = scheduleTitle;
        this.schedeuleContents = schedeuleContents;
    }
}
