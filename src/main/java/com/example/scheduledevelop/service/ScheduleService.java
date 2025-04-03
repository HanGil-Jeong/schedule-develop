package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

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

    public ScheduleResponseDto findById(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(findSchedule.getId(),findSchedule.getWriterUsername(), findSchedule.getScheduleTitle(), findSchedule.getScheduleContents());
    }

    @Transactional
    public void updateSchedule(Long id, String writerUsername, String scheduleTitle, String scheduleContents) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.updateSchedule(writerUsername, scheduleTitle, scheduleContents);

    }
}
