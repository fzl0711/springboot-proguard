package com.shark.example.service.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginOutput implements Serializable {

    @JsonProperty("jwt")
    @SerializedName("jwt")
    @ApiModelProperty(value = "token")
    private String jwt;
}
