package com.example.demo.app;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )

    private long id;
    private String description;
    private int user_id;
    private String image;
    private LocalDate created_at;
    @Transient
    private boolean followed;
    @Transient
    private boolean liked;

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int userID) {
        this.user_id = userID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate createdAt) {
        this.created_at = createdAt;
    }

    @Override
    public String toString() {
        return "Post{" +
                "description='" + description + '\'' +
                ", owner='" + user_id + '\'' +
                ", image='" + image + '\'' +
                ", liked='" + liked + '\'' +
                ", created_at=" + created_at +
                '}';
    }

}
