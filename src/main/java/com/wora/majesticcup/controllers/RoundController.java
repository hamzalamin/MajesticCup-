package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.round.CreateRoundDto;
import com.wora.majesticcup.models.DTOs.round.RoundDto;
import com.wora.majesticcup.models.DTOs.round.UpdateRoundDto;
import com.wora.majesticcup.services.INTER.IRoundService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RoundController {
    private final IRoundService roundService;

    @PostMapping("/rounds")
    public ResponseEntity<RoundDto> create(@RequestBody @Valid CreateRoundDto createRoundDto) {
        return new ResponseEntity<>(roundService.save(createRoundDto), HttpStatus.CREATED);
    }

    @GetMapping("/rounds")
    public ResponseEntity<List<RoundDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<RoundDto> rounds = roundService.findAll(pageNumber, size);
        return new ResponseEntity<>(rounds, HttpStatus.OK);
    }

    @GetMapping("/rounds/{id}")
    public ResponseEntity<RoundDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(roundService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/rounds/{id}")
    public ResponseEntity<RoundDto> update(
            @RequestBody @Valid UpdateRoundDto updateRoundDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(roundService.update(updateRoundDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/rounds/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        roundService.delete(id);
        return new ResponseEntity<>("ROUND WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
