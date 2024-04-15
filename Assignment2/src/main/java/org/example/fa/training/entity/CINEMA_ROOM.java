package org.example.fa.training.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
@Getter
@Setter
@Entity
@Table(name = "cinema_room")
public class CINEMA_ROOM {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long room_Id;
    @Size(max = 255)
    @Column(name = "cinema_room_name")
    private String cinema_room_name;
    @Column(name = "seat_quantity")
    private int seat_quantity;
    // mapping cinema_room_detail
    @OneToOne
    @JoinColumn(name = "cinema_room_Id")
    private CINEMA_ROOM_DETAIL cinema_room_detail;
}
