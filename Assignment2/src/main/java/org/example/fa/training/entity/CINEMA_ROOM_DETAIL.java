package org.example.fa.training.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cinema_room_detail")
public class CINEMA_ROOM_DETAIL {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long cinema_room_Id;
    @Column(name = "room_rate")
    private int room_rate;
    @Column(name = "active_date")
    private LocalDate active_date;
    @Size(max = 250)
    @Column(name = "room_description")
    private String room_description;
    // toString

    @Override
    public String toString() {
        return "CINEMA_ROOM_DETAIL{" +
                "cinema_room_Id=" + cinema_room_Id +
                ", room_rate=" + room_rate +
                ", active_date=" + active_date +
                ", room_description='" + room_description + '\'' +
                '}';
    }
}
