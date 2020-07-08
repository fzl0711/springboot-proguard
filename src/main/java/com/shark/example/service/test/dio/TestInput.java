package com.shark.example.service.test.dio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ApiModel(description = "測試Input")
@Data
public class TestInput implements Serializable {

    @ApiModelProperty(value = "參數", required = true)
    @NotEmpty
    @JsonProperty("parameter")
    @SerializedName("parameter")
    private String parameter;
}
