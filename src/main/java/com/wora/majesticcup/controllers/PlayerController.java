package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.player.CreatePlayerDto;
import com.wora.majesticcup.models.DTOs.player.PlayerDto;
import com.wora.majesticcup.models.DTOs.player.UpdatePlayerDto;
import com.wora.majesticcup.services.INTER.IPlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PlayerController {
    private final IPlayerService playerService;

//    @PostMapping("/players")
//    public ResponseEntity<PlayerDto> create(@RequestBody @Valid CreatePlayerDto createPlayerDto) {
//        return new ResponseEntity<>(playerService.save(createPlayerDto), HttpStatus.CREATED);
//    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<PlayerDto> players = playerService.findAll(pageNumber, size);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<PlayerDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(playerService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<PlayerDto> update(
            @RequestBody @Valid UpdatePlayerDto updatePlayerDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(playerService.update(updatePlayerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        playerService.delete(id);
        return new ResponseEntity<>("PLAYER WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
