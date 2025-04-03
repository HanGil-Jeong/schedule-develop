package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String writerUsername;

    @Column(nullable = false)
    private String scheduleTitle;

    @Column(nullable = false)
    private String scheduleContents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule() {}

    public Schedule(String writerUsername, String scheduleTitle, String scheduleContents) {
        this.writerUsername = writerUsername;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContents = scheduleContents;
    }

    //일정 수정을 위한 SETTER
    public void updateSchedule(String writerUsername, String scheduleTitle, String scheduleContents) {
        this.writerUsername = writerUsername;
        this.scheduleTitle = scheduleTitle;
        this.scheduleContents = scheduleContents;
    }

}
