package com.wora.majesticcup.controllers.secure;

import com.wora.majesticcup.models.DTOs.competition.CompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.CreateCompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.UpdateCompetitionDto;
import com.wora.majesticcup.models.DTOs.player.CreatePlayerDto;
import com.wora.majesticcup.models.DTOs.player.PlayerDto;
import com.wora.majesticcup.models.DTOs.player.UpdatePlayerDto;
import com.wora.majesticcup.models.DTOs.result.CreateResultDto;
import com.wora.majesticcup.models.DTOs.result.ResultDto;
import com.wora.majesticcup.models.DTOs.result.UpdateResultDto;
import com.wora.majesticcup.models.DTOs.team.CreateTeamDto;
import com.wora.majesticcup.models.DTOs.team.TeamDto;
import com.wora.majesticcup.models.DTOs.team.UpdateTeamDto;
import com.wora.majesticcup.services.INTER.ICompetitionService;
import com.wora.majesticcup.services.INTER.IPlayerService;
import com.wora.majesticcup.services.INTER.IResultService;
import com.wora.majesticcup.services.INTER.ITeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final ICompetitionService competitionService;
    private final ITeamService teamService;
    private final IPlayerService playerService;
    private final IResultService resultService;

    @PostMapping("/competitions")
    public ResponseEntity<CompetitionDto> createCompetition(@RequestBody @Valid CreateCompetitionDto createCompetitionDto) {
        return new ResponseEntity<>(competitionService.save(createCompetitionDto), HttpStatus.CREATED);
    }

    @GetMapping("/competitions/{id}")
    public ResponseEntity<CompetitionDto> findCompetitionById(@PathVariable String id) {
        return new ResponseEntity<>(competitionService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/competitions/{id}")
    public ResponseEntity<CompetitionDto> updateCompetition(
            @RequestBody @Valid UpdateCompetitionDto updateCompetitionDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(competitionService.update(updateCompetitionDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/competitions/{id}")
    public ResponseEntity<String> deleteCompetition(@PathVariable String id) {
        competitionService.delete(id);
        return new ResponseEntity<>("COMPETITION WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamDto> createTeam(@RequestBody @Valid CreateTeamDto createTeamDto) {
        return new ResponseEntity<>(teamService.save(createTeamDto), HttpStatus.CREATED);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<TeamDto> findTeamById(@PathVariable String id) {
        return new ResponseEntity<>(teamService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<TeamDto> updateTeam(
            @RequestBody @Valid UpdateTeamDto updateTeamDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(teamService.update(updateTeamDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable String id) {
        teamService.delete(id);
        return new ResponseEntity<>("TEAM WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }

    @PostMapping("/players")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody @Valid CreatePlayerDto createPlayerDto) {
        return new ResponseEntity<>(playerService.save(createPlayerDto), HttpStatus.CREATED);
    }


    @GetMapping("/players/{id}")
    public ResponseEntity<PlayerDto> findPlayerById(@PathVariable String id) {
        return new ResponseEntity<>(playerService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(
            @RequestBody @Valid UpdatePlayerDto updatePlayerDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(playerService.update(updatePlayerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable String id) {
        playerService.delete(id);
        return new ResponseEntity<>("PLAYER WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }

    @PostMapping("/results")
    public ResponseEntity<ResultDto> createResult(@RequestBody @Valid CreateResultDto createResultDto) {
        return new ResponseEntity<>(resultService.save(createResultDto), HttpStatus.CREATED);
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<ResultDto> findResultById(@PathVariable String id) {
        return new ResponseEntity<>(resultService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/results/{id}")
    public ResponseEntity<ResultDto> updateResult(
            @RequestBody @Valid UpdateResultDto updateResultDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(resultService.update(updateResultDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/results/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable String id) {
        resultService.delete(id);
        return new ResponseEntity<>("RESULT WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
