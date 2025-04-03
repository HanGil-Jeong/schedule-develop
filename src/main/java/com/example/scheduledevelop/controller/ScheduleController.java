package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.CreateScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> scheduleSave(@RequestBody CreateScheduleRequestDto requestDto){

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.scheduleSave(
                        requestDto.getWriterUsername(),
                        requestDto.getScheduleTitle(),
                        requestDto.getScheduleContents()
                );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }
}
