package com.example.demo.app;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private long id;
    private String username;
    private String email;
    private String full_name;
    private String profile_picture;
    private String bio;
    private LocalDate created_at;

    public User() {  }

    /*
    Getter and Setters
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String fullname) {
        this.full_name = fullname;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profilePicture) {
        this.profile_picture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate createdAt) {
        this.created_at = createdAt;
    }


    public User(String username, String email, String full_name, String profile_picture, String bio, LocalDate created_at) {
        this.username = username;
        this.email = email;
        this.full_name = full_name;
        this.profile_picture = profile_picture;
        this.bio = bio;
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                ", bio='" + bio + '\'' +
                ", full_name=" + full_name +
                '}';
    }
}
