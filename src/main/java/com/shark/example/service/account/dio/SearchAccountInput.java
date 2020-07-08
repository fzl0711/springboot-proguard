package com.shark.example.service.account.dio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SearchAccountInput implements Serializable {
    @ApiModelProperty(value = "分页码", required = true)
    @JsonProperty("pageNumber")
    @SerializedName("pageNumber")
    @NotNull
    private int pageNumber;

    @ApiModelProperty(value = "分页大小", required = true)
    @JsonProperty("pageSize")
    @SerializedName("pageSize")
    @NotNull
    private int pageSize;

    @ApiModelProperty(value = "关键字")
    @JsonProperty("keyword")
    @SerializedName("keyword")
    private String keyword;
}
