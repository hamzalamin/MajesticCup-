package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.team.CreateTeamDto;
import com.wora.majesticcup.models.DTOs.team.TeamDto;
import com.wora.majesticcup.models.DTOs.team.UpdateTeamDto;
import com.wora.majesticcup.services.INTER.ITeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TeamController {
    private final ITeamService teamService;

    @PostMapping("/teams")
    public ResponseEntity<TeamDto> create(@RequestBody @Valid CreateTeamDto createTeamDto) {
        return new ResponseEntity<>(teamService.save(createTeamDto), HttpStatus.CREATED);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<TeamDto> teams = teamService.findAll(pageNumber, size);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<TeamDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(teamService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<TeamDto> update(
            @RequestBody @Valid UpdateTeamDto updateTeamDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(teamService.update(updateTeamDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        teamService.delete(id);
        return new ResponseEntity<>("TEAM WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
