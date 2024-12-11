package com.wora.majesticcup.services.IMPL;

import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.mappers.CompetitionMapper;
import com.wora.majesticcup.models.DTOs.competition.CompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.CreateCompetitionDto;
import com.wora.majesticcup.models.DTOs.competition.UpdateCompetitionDto;
import com.wora.majesticcup.models.entities.Competition;
import com.wora.majesticcup.repositories.CompetitionRepository;
import com.wora.majesticcup.services.INTER.ICompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionService implements ICompetitionService {
    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;

    @Override
    public Competition getCompetitionEntityById(String id) {
        return competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition", id));
    }

    @Override
    public CompetitionDto save(CreateCompetitionDto createCompetitionDto) {
        Competition competition = competitionMapper.toEntity(createCompetitionDto);
        Competition savedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDto(savedCompetition);
    }

    @Override
    public CompetitionDto findById(String id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition", id));

        return competitionMapper.toDto(competition);
    }

    @Override
    public CompetitionDto update(UpdateCompetitionDto updateCompetitionDto, String id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition", id));

        competition.setName(updateCompetitionDto.name());
        competition.setCurrentRound(updateCompetitionDto.currentRound());
        competition.setNumberOfTeams(updateCompetitionDto.numberOfTeams());

        Competition updatedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDto(updatedCompetition);
    }

    @Override
    public List<CompetitionDto> findAll(Integer pageNumber, Integer size) {
        PageRequest pageable = PageRequest.of(pageNumber, size);
        return competitionRepository.findAll(pageable).stream()
                .map(competitionMapper::toDto)
                .toList();    }

    @Override
    public void delete(String id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Competition", id));
        competitionRepository.delete(competition);
    }
}
