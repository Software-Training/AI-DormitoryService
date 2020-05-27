package com.example.bean;

import java.io.Serializable;

public class Userinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String numberId;
    private String name;
    private long dormitoryId;
    private String sex;
    private String subject;
    private String phone;
    private String email;

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

    public long getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(long dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
