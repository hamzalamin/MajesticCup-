package com.wora.majesticcup.controllers.secure;

import com.wora.majesticcup.models.DTOs.result.CreateResultDto;
import com.wora.majesticcup.models.DTOs.result.ResultDto;
import com.wora.majesticcup.models.DTOs.result.UpdateResultDto;
import com.wora.majesticcup.services.INTER.IResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/operator/")
@RequiredArgsConstructor
public class OperatorController {
    private final IResultService resultService;

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
