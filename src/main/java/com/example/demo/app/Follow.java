package com.example.demo.app;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Follow {
    @Id
    @SequenceGenerator(
            name = "follow_sequence",
            sequenceName = "follow_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "follow_sequence"
    )

    private int follower_id;
    private int following_id;
    private LocalDate created_at;
}
