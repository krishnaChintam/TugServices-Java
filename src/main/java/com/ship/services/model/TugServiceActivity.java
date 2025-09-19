package com.ship.services.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "TugServiceActivity")
public class TugServiceActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActivityId")
    private Long activityId;

    @Column(name = "ActivityDate", nullable = false)
    private String activityDate;   // Or LocalDate

    @Column(name = "ActivityTime", nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")   // 👈 this ensures JSON shows only hh:mm:ss
    private LocalTime activityTime;   // Or LocalTime

    @Column(name = "Description", nullable = false, length = 500)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ServiceId", nullable = false)
    @JsonIgnore
    private TugServiceHeader header;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public LocalTime getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(LocalTime activityTime) {
        this.activityTime = activityTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TugServiceHeader getHeader() {
        return header;
    }

    public void setHeader(TugServiceHeader header) {
        this.header = header;
    }
}
