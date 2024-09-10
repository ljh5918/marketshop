package com.marketshop.marketshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.PreUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime reTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column(name = "modified_date")
    @LastModifiedDate
    private String modifiedDate;

    @PreUpdate
    public void onPreUpdate() {
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    }
}
