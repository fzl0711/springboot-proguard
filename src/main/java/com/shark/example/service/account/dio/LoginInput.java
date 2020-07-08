package com.shark.example.service.account.dio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class LoginInput implements Serializable {
    @NotEmpty
    @ApiModelProperty(value = "账号", required = true)
    @JsonProperty("account")
    @SerializedName("account")
    private String account;

    @NotEmpty
    @ApiModelProperty(value = "密码")
    @JsonProperty("password")
    @SerializedName("password")
    private String password;
}
