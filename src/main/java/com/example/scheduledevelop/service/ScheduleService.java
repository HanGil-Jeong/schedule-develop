package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto scheduleSave(String writerUsername, String scheduleTitle, String schedeuleContents) {

        Schedule schedule = new Schedule(writerUsername, scheduleTitle, schedeuleContents);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getWriterUsername(), savedSchedule.getScheduleTitle(), savedSchedule.getScheduleContents());
    }

    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }
}
