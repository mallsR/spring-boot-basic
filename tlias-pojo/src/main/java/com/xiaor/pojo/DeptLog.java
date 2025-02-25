package com.xiaor.pojo;

import java.time.LocalDateTime;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DeptLog {
    private Integer id;
    private LocalDateTime createTime;
    private String description;

    public DeptLog() {
    }

    public DeptLog(Integer id, LocalDateTime createTime, String description) {
        this.id = id;
        this.createTime = createTime;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DeptLog{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                '}';
    }
}
