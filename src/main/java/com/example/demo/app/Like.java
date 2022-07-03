package com.example.demo.app;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Like {
    @Id
    @SequenceGenerator(
            name = "like_sequence",
            sequenceName = "like_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "like_sequence"
    )

    private int post_id;
    private int user_id;
    private LocalDate created_at;
}
