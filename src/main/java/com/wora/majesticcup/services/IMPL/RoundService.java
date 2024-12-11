package com.wora.majesticcup.services.IMPL;

import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.mappers.RoundMapper;
import com.wora.majesticcup.models.DTOs.round.CreateRoundDto;
import com.wora.majesticcup.models.DTOs.round.RoundDto;
import com.wora.majesticcup.models.DTOs.round.UpdateRoundDto;
import com.wora.majesticcup.models.entities.Competition;
import com.wora.majesticcup.models.entities.Round;
import com.wora.majesticcup.repositories.RoundRepository;
import com.wora.majesticcup.services.INTER.ICompetitionService;
import com.wora.majesticcup.services.INTER.IRoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoundService implements IRoundService {
    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;
    private final ICompetitionService competitionService;

    @Override
    public RoundDto save(CreateRoundDto createRoundDto) {
        Competition competition = competitionService.getCompetitionEntityById(createRoundDto.competitionId());
        Round round = roundMapper.toEntity(createRoundDto);
        round.setCompetitionId(competition.getId());
        Round savedRound = roundRepository.save(round);
        return roundMapper.toDto(savedRound);
    }

    @Override
    public RoundDto findById(String id) {
        Round round = roundRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Round", id));

        return roundMapper.toDto(round);
    }

    @Override
    public RoundDto update(UpdateRoundDto updateRoundDto, String id) {
        Round round = roundRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Round", id));

        Competition competition = competitionService.getCompetitionEntityById(updateRoundDto.competitionId());

        round.setRoundNumber(updateRoundDto.roundNumber());
        round.setCompetitionId(competition.getId());
        round.setRoundNumber(updateRoundDto.roundNumber());

        Round updatedRound = roundRepository.save(round);
        return roundMapper.toDto(updatedRound);
    }

    @Override
    public List<RoundDto> findAll(Integer pageNumber, Integer size) {
        PageRequest pageable = PageRequest.of(pageNumber, size);
        return roundRepository.findAll(pageable).stream()
                .map(roundMapper::toDto)
                .toList();
    }

    @Override
    public void delete(String id) {
        Round round = roundRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Round", id));
        roundRepository.delete(round);
    }

    @Override
    public Round getRoundEntityById(String id) {
        return roundRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Round", id));
    }
}
