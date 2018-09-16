package com.adidas.challenge.distancecalculator.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "Stage of the journey.")
@Data
@Builder
public class Stage {
    @ApiModelProperty(value = "First city of the stage.")
    String city;
    @ApiModelProperty(value = "Time of the stage. In the case of connections, it is always 1.")
    Double meanTime;

}
