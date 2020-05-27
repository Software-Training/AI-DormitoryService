package com.example.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class RecordView implements Serializable {
    private static final long serialVersionUID = 1L;
    private long  recordId;
    private String numberId;
    private String name;
    private String dormitoryName;
    @JsonFormat(pattern=" HH:mm:ss",timezone="GMT+8")
    private String inTime;
    @JsonFormat(pattern="HH:mm:ss",timezone="GMT+8")
    private String outTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String date;

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }
    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDormitoryName() {
        return dormitoryName;
    }

    public void setDormitoryName(String dormitoryName) {
        this.dormitoryName = dormitoryName;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
