package com.wora.majesticcup.services.IMPL;

import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.mappers.TeamMapper;
import com.wora.majesticcup.models.DTOs.team.CreateTeamDto;
import com.wora.majesticcup.models.DTOs.team.TeamDto;
import com.wora.majesticcup.models.DTOs.team.UpdateTeamDto;
import com.wora.majesticcup.models.entities.Team;
import com.wora.majesticcup.repositories.TeamRepository;
import com.wora.majesticcup.services.INTER.ITeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService implements ITeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public TeamDto save(CreateTeamDto createTeamDto) {
        Team team = teamMapper.toEntity(createTeamDto);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDto(savedTeam);
    }

    @Override
    public TeamDto findById(String id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team", id));
        return teamMapper.toDto(team);    }

    @Override
    public TeamDto update(UpdateTeamDto updateTeamDto, String id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team", id));
        if (updateTeamDto.name() != null) {
            team.setName(updateTeamDto.name());
        }
        if (updateTeamDto.city() != null) {
            team.setCity(updateTeamDto.city());
        }
        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDto(updatedTeam);
    }

    @Override
    public List<TeamDto> findAll(Integer pageNumber, Integer size) {
        PageRequest pageable = PageRequest.of(pageNumber, size);
        return teamRepository.findAll(pageable).stream()
                .map(teamMapper::toDto)
                .toList();    }

    @Override
    public void delete(String id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team", id));
        teamRepository.delete(team);
    }
}
