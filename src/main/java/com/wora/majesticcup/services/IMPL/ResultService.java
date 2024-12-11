package com.wora.majesticcup.services.IMPL;

import com.wora.majesticcup.exceptions.EntityNotFoundException;
import com.wora.majesticcup.mappers.ResultMapper;
import com.wora.majesticcup.models.DTOs.result.CreateResultDto;
import com.wora.majesticcup.models.DTOs.result.ResultDto;
import com.wora.majesticcup.models.DTOs.result.UpdateResultDto;
import com.wora.majesticcup.models.entities.Match;
import com.wora.majesticcup.models.entities.embeddedDocuments.Result;
import com.wora.majesticcup.repositories.ResultRepository;
import com.wora.majesticcup.services.INTER.IMatchService;
import com.wora.majesticcup.services.INTER.IResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService implements IResultService {
    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper;
    private final IMatchService matchService;

    @Override
    public ResultDto save(CreateResultDto createResultDto) {
        Match match = matchService.getMatchEntityById(createResultDto.matchId());
        Result result = resultMapper.toEntity(createResultDto);
        result.setMatchId(match);
        Result savedResult = resultRepository.save(result);
        return resultMapper.toDto(savedResult);
    }

    @Override
    public ResultDto findById(String id) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Result", id));
        return resultMapper.toDto(result);
    }

    @Override
    public ResultDto update(UpdateResultDto updateResultDto, String id) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Result", id));
        Match match = matchService.getMatchEntityById(updateResultDto.matchId());

        result.setTeam1Goals(updateResultDto.scoreTeam1());
        result.setTeam2Goals(updateResultDto.scoreTeam2());
        result.setMatchId(match);

        Result updatedResult = resultRepository.save(result);
        return resultMapper.toDto(updatedResult);    }

    @Override
    public List<ResultDto> findAll(Integer pageNumber, Integer size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return resultRepository.findAll(pageable).stream()
                .map(resultMapper::toDto)
                .toList();
    }

    @Override
    public void delete(String id) {
        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Result", id));
        resultRepository.delete(result);
    }
}
