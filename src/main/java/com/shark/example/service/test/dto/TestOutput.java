package com.shark.example.service.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "測試Output")
@Data
public class TestOutput implements Serializable {
    @ApiModelProperty(value = "參數", required = true)
    @JsonProperty("parameter")
    @SerializedName("parameter")
    private String parameter;
}
