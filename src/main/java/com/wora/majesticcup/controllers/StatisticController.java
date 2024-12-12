package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.statistic.CreateStatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.StatisticDto;
import com.wora.majesticcup.models.DTOs.statistic.UpdateStatisticDto;
import com.wora.majesticcup.services.INTER.IStatisticService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StatisticController {
    private final IStatisticService statisticService;

    @PostMapping("/statistics")
    public ResponseEntity<StatisticDto> create(@RequestBody @Valid CreateStatisticDto createStatisticDto) {
        return new ResponseEntity<>(statisticService.save(createStatisticDto), HttpStatus.CREATED);
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<StatisticDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<StatisticDto> statistics = statisticService.findAll(pageNumber, size);
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/statistics/{id}")
    public ResponseEntity<StatisticDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(statisticService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/statistics/{id}")
    public ResponseEntity<StatisticDto> update(
            @RequestBody @Valid UpdateStatisticDto updateStatisticDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(statisticService.update(updateStatisticDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/statistics/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        statisticService.delete(id);
        return new ResponseEntity<>("STATISTIC WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
