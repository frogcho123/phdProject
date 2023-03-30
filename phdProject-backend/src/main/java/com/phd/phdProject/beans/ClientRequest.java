package com.phd.phdProject.beans;

import com.phd.phdProject.entities.City;
import com.phd.phdProject.entities.Sex;
public class ClientRequest {
    Long id;
    String firstName;
    String secondName;
    String lastName;
    String nickName;
    Sex sex;
    Long egn;
    City city;
    Double current;
    Double saving;
    Double credit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Long getEgn() {
        return egn;
    }

    public void setEgn(Long egn) {
        this.egn = egn;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City cityId) {
        this.city = cityId ;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Double getSaving() {
        return saving;
    }

    public void setSaving(Double saving) {
        this.saving = saving;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }
}
