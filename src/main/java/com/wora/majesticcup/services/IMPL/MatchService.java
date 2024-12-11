package com.wora.majesticcup.services.IMPL;

import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.mappers.MatchMapper;
import com.wora.majesticcup.models.DTOs.match.CreateMatchDto;
import com.wora.majesticcup.models.DTOs.match.MatchDto;
import com.wora.majesticcup.models.DTOs.match.UpdateMatchDto;
import com.wora.majesticcup.models.entities.Match;
import com.wora.majesticcup.models.entities.Team;
import com.wora.majesticcup.repositories.MatchRepository;
import com.wora.majesticcup.services.INTER.IMatchService;
import com.wora.majesticcup.services.INTER.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService implements IMatchService {
    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final ITeamService teamService;

    @Override
    public MatchDto save(CreateMatchDto createMatchDto) {
        Team team1 = teamService.getTeamEntityById(createMatchDto.team1());
        Team team2 = teamService.getTeamEntityById(createMatchDto.team2());

        Match match = matchMapper.toEntity(createMatchDto);
        match.setTeam1(team1.getId());
        match.setTeam2(team2.getId());
        match.setRound(createMatchDto.round());
        Match savedMatch = matchRepository.save(match);
        return matchMapper.toDto(savedMatch);
    }

    @Override
    public MatchDto findById(String id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match", id));

        return matchMapper.toDto(match);
    }

    @Override
    public MatchDto update(UpdateMatchDto updateMatchDto, String id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match", id));
            Team team = teamService.getTeamEntityById(updateMatchDto.team1());

        if (updateMatchDto.team1() != null) {
            match.setTeam1(team.getId());
        }
        if (updateMatchDto.team2() != null) {
            match.setTeam2(team.getId());
        }

        Match updatedMatch = matchRepository.save(match);
        return matchMapper.toDto(updatedMatch);
    }

    @Override
    public List<MatchDto> findAll(Integer pageNumber, Integer size) {
        PageRequest pageable = PageRequest.of(pageNumber, size);
        return matchRepository.findAll(pageable).stream()
                .map(matchMapper::toDto)
                .toList();
    }

    @Override
    public void delete(String id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match", id));
        matchRepository.delete(match);
    }

    @Override
    public Match getMatchEntityById(String id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match", id));
    }
}
