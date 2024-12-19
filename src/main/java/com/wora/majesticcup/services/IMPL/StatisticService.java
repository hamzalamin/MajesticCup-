package com.wora.majesticcup.services.IMPL;


import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.mappers.StatisticMapper;
import com.wora.majesticcup.models.DTOs.statistic.CreateStatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.StatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.UpdateStatisticDto;
import com.wora.majesticcup.models.entities.embeddedDocuments.Player;
import com.wora.majesticcup.models.entities.embeddedDocuments.Result;
import com.wora.majesticcup.models.entities.embeddedDocuments.Statistic;
import com.wora.majesticcup.repositories.StatisticRepository;
import com.wora.majesticcup.services.INTER.IPlayerService;
import com.wora.majesticcup.services.INTER.IResultService;
import com.wora.majesticcup.services.INTER.IStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService implements IStatisticService {
    private final StatisticRepository statisticRepository;
    private final StatisticMapper statisticMapper;
    private final IResultService resultService;
    private final IPlayerService playerService;


    @Override
    public StatisticDto save(CreateStatisticDto createStatisticDto) {
        Statistic statistic = statisticMapper.toEntity(createStatisticDto);
        Player player = playerService.findEntityById(createStatisticDto.playerId());
        statistic.setPlayerId(player);
        Statistic savedStatistic = statisticRepository.save(statistic);
        return statisticMapper.toDto(savedStatistic);
    }

    @Override
    public StatisticDto findById(String id) {
        Statistic statistic = statisticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Statistic", id));
        return statisticMapper.toDto(statistic);
    }

    @Override
    public StatisticDto update(UpdateStatisticDto updateStatisticDto, String id) {
        Statistic statistic = statisticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Statistic", id));

        Player player = playerService.findEntityById(updateStatisticDto.playerId());

        statistic.setGoals(updateStatisticDto.goals());
        statistic.setAssists(updateStatisticDto.assists());
        statistic.setYellowCards(updateStatisticDto.yellowCards());
        statistic.setRedCards(updateStatisticDto.redCards());

        statistic.setPlayerId(player);

        Statistic updatedStatistic = statisticRepository.save(statistic);
        return statisticMapper.toDto(updatedStatistic);
    }

    @Override
    public List<StatisticDto> findAll(Integer pageNumber, Integer size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return statisticRepository.findAll(pageable).stream()
                .map(statisticMapper::toDto)
                .toList();
    }

    @Override
    public void delete(String id) {
        Statistic statistic = statisticRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Statistic", id));
        statisticRepository.delete(statistic);
    }
}
