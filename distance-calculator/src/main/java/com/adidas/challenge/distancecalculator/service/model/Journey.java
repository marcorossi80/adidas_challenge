package com.adidas.challenge.distancecalculator.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@ApiModel(value = "A journey between two cities, listing its stages.")
@Data
@AllArgsConstructor
public class Journey {
    @ApiModelProperty(value = "List of the stages of the journey.")
    List<Stage> stageList;
}
