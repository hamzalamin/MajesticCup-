package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.match.CreateMatchDto;
import com.wora.majesticcup.models.DTOs.match.MatchDto;
import com.wora.majesticcup.models.DTOs.match.UpdateMatchDto;
import com.wora.majesticcup.services.INTER.IMatchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MatchController {
    private final IMatchService matchService;

    @PostMapping("/matches")
    public ResponseEntity<MatchDto> create(@RequestBody @Valid CreateMatchDto createMatchDto) {
        return new ResponseEntity<>(matchService.save(createMatchDto), HttpStatus.CREATED);
    }

    @GetMapping("/matches")
    public ResponseEntity<List<MatchDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<MatchDto> matches = matchService.findAll(pageNumber, size);
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }

    @GetMapping("/matches/{id}")
    public ResponseEntity<MatchDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(matchService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/matches/{id}")
    public ResponseEntity<MatchDto> update(
            @RequestBody @Valid UpdateMatchDto updateMatchDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(matchService.update(updateMatchDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/matches/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        matchService.delete(id);
        return new ResponseEntity<>("MATCH WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
