package com.ship.services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
    private String activityTime;   // Or LocalTime

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

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
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
