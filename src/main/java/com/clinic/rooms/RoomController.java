package com.clinic.rooms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping ("/rooms")
public class RoomController {

    private RoomRepository roomRepository;
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    @GetMapping ("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
    }

    @GetMapping ("/available/{isAvailable}")
    public List<Room> getAvailableRooms(@PathVariable boolean isAvailable) {
        return roomRepository.findAllByIsAvailable(isAvailable);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @DeleteMapping ("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }
}
