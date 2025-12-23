package com.example.demo.dto;

public class StudentProfileDto {

    private String name;
    private int age;
    private String gender;
    private String roomTypePreference;

    public StudentProfileDto() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getRoomTypePreference() {
        return roomTypePreference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRoomTypePreference(String roomTypePreference) {
        this.roomTypePreference = roomTypePreference;
    }
}
