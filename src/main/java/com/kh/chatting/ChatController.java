package com.kh.chatting;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {
    private final ChatService chatService;
    @PostMapping("/chat")
    public ResponseEntity<String> createRoom(@RequestBody String name) {
        ChatRoom room = chatService.createRoom(name);
        System.out.println(room.getRoomId());
        return new ResponseEntity(room.getRoomId(), HttpStatus.OK);
    }
    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
}
