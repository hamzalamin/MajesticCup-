package com.wora.majesticcup.controllers;

import com.wora.majesticcup.models.DTOs.result.CreateResultDto;
import com.wora.majesticcup.models.DTOs.result.ResultDto;
import com.wora.majesticcup.models.DTOs.result.UpdateResultDto;
import com.wora.majesticcup.services.INTER.IResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ResultController {
    private final IResultService resultService;

    @PostMapping("/results")
    public ResponseEntity<ResultDto> create(@RequestBody @Valid CreateResultDto createResultDto) {
        return new ResponseEntity<>(resultService.save(createResultDto), HttpStatus.CREATED);
    }

    @GetMapping("/results")
    public ResponseEntity<List<ResultDto>> findAll(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size
    ) {
        List<ResultDto> results = resultService.findAll(pageNumber, size);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<ResultDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(resultService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/results/{id}")
    public ResponseEntity<ResultDto> update(
            @RequestBody @Valid UpdateResultDto updateResultDto,
            @PathVariable String id
    ) {
        return new ResponseEntity<>(resultService.update(updateResultDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/results/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        resultService.delete(id);
        return new ResponseEntity<>("RESULT WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }
}
