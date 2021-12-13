package com.jx2lee.mockito.domain;

import com.jx2lee.mockito.study.StudyStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Study {
    private String owner;
    private LocalDateTime openDateTime;
    private StudyStatus status = StudyStatus.DRAFT;
    public Study(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(Member owner) {
        this.owner = owner.getName();
    }
    public StudyStatus getStatus() {
        return status;
    }

    public LocalDateTime getOpenDateTime() {
        return openDateTime;
    }
    public void open() {
        this.openDateTime = LocalDateTime.now();
        this.status = StudyStatus.OPENED;
    }
}
