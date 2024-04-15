package org.example.fa.training.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "seat")
public class SEAT {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long seat_Id;
    @Column(name = "seat_Row")
    private int seat_Row;
    @Size(max = 255)
    @Column(name = "seat_Column")
    private String seat_Column;
    @Size(max = 255,message = "status:'Available','Not Available','Booked'")
    @Column(name = "seat_status")
    private String seat_status;
    @Size(max = 255,message = "type:'VIP','Normal'")
    @Column(name = "seat_type")
    private String seat_type;
    // mapping cinemaRoom
    @OneToMany
    @JoinColumn(name = "cinema_room_id")
    private CINEMA_ROOM cinema_room;
    // toString

    @Override
    public String toString() {
        return "SEAT{" +
                "seat_Id=" + seat_Id +
                ", seat_Row=" + seat_Row +
                ", seat_Column='" + seat_Column + '\'' +
                ", seat_status=" + seat_status +
                ", seat_type='" + seat_type + '\'' +
                ", cinema_room=" + cinema_room +
                '}';
    }
}
