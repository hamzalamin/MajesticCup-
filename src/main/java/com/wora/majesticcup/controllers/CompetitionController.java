package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.competition.CompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.CreateCompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.UpdateCompetitionDto;
import com.wora.majesticcup.services.INTER.ICompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CompetitionController {
    private final ICompetitionService competitionService;

    @PostMapping("/competitions")
    public ResponseEntity<CompetitionDto> create(@RequestBody @Valid CreateCompetitionDto createCompetitionDto) {
        return new ResponseEntity<>(competitionService.save(createCompetitionDto), HttpStatus.CREATED);
    }

    @GetMapping("/competitions")
    public ResponseEntity<List<CompetitionDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<CompetitionDto> competitions = competitionService.findAll(pageNumber, size);
        return new ResponseEntity<>(competitions, HttpStatus.OK);
    }

    @GetMapping("/competitions/{id}")
    public ResponseEntity<CompetitionDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(competitionService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/competitions/{id}")
    public ResponseEntity<CompetitionDto> update(
            @RequestBody @Valid UpdateCompetitionDto updateCompetitionDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(competitionService.update(updateCompetitionDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/competitions/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        competitionService.delete(id);
        return new ResponseEntity<>("COMPETITION WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
