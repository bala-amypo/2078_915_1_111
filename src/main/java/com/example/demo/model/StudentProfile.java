package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserAccount userAccount;

    private String name;
    private int age;
    private String gender;
    private String roomTypePreference;

    public Long getId() { return id; }
    public UserAccount getUserAccount() { return userAccount; }
    public int getAge() { return age; }

    public void setUserAccount(UserAccount userAccount) { this.userAccount = userAccount; }
    public void setAge(int age) { this.age = age; }
}
