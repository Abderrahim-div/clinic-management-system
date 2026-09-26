package com.clinic.rooms;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String roomName;
    public enum RoomType {
        CONSULTATION,
        SURGERY,
        EMERGENCY,
        LABORATORY,
        RADIOLOGY,
        WAITING
    }
    private RoomType roomType;
    private int capacity;
    private boolean isAvailable;
}
