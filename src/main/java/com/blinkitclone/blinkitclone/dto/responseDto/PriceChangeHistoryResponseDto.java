package com.blinkitclone.blinkitclone.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class PriceChangeHistoryResponseDto {
    String Error;
}
