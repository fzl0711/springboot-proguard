package com.shark.example.service.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Setter
@Getter
@JsonInclude(NON_NULL)
public class BaseResponseEntity<Data> implements Serializable {
    @JsonProperty("data")
    @SerializedName("data")
    private Data data;

    @JsonProperty("success")
    @SerializedName("success")
    private boolean success;

    @JsonProperty("errorMessage")
    @SerializedName("errorMessage")
    private String errorMessage;
}
