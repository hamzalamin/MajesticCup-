package com.wora.majesticcup.services.INTER;

import com.wora.majesticcup.models.DTOs.result.CreateResultDto;
import com.wora.majesticcup.models.DTOs.result.ResultDto;
import com.wora.majesticcup.models.DTOs.result.UpdateResultDto;
import com.wora.majesticcup.services.GenericService;

public interface IResultService extends GenericService<CreateResultDto, UpdateResultDto, ResultDto, String> {
}
