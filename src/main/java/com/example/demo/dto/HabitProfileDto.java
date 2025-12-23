package com.example.demo.dto;

public class HabitProfileDto {

    private boolean smoking;
    private boolean drinking;
    private int cleanlinessLevel;
    private int noisePreference;

    public HabitProfileDto() {
    }

    public boolean isSmoking() {
        return smoking;
    }

    public boolean isDrinking() {
        return drinking;
    }

    public int getCleanlinessLevel() {
        return cleanlinessLevel;
    }

    public int getNoisePreference() {
        return noisePreference;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public void setDrinking(boolean drinking) {
        this.drinking = drinking;
    }

    public void setCleanlinessLevel(int cleanlinessLevel) {
        this.cleanlinessLevel = cleanlinessLevel;
    }

    public void setNoisePreference(int noisePreference) {
        this.noisePreference = noisePreference;
    }
}
