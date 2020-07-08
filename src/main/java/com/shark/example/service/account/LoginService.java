package com.shark.example.service.account;

import com.shark.example.configuration.security.SecurityConfiguration;
import com.shark.example.dao.entity.AccountDaoEntity;
import com.shark.example.dao.repository.AccountRepository;
import com.shark.example.service.account.dio.LoginInput;
import com.shark.example.service.account.dto.LoginOutput;
import com.shark.example.service.base.BaseResponseEntity;
import com.shark.example.service.base.BaseService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service("LoginService")
public class LoginService extends BaseService<LoginInput, BaseResponseEntity<LoginOutput>> {

    private final AccountRepository accountRepository;

    @Override
    public BaseResponseEntity<LoginOutput> start(LoginInput loginInput) {
        AccountDaoEntity accountDaoEntity = accountRepository.findByAccount(loginInput.getAccount());
        BaseResponseEntity<LoginOutput> responseEntity = new BaseResponseEntity();
        responseEntity.setSuccess(true);
        LoginOutput loginOutput = new LoginOutput();
        String accessToken = Jwts.builder()
                .setSubject(String.valueOf(accountDaoEntity.getId()))
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConfiguration.ACCESS_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConfiguration.ACCESS_SECRET.getBytes())
                .compact();
        loginOutput.setJwt(accessToken);
        responseEntity.setData(loginOutput);
        return responseEntity;
    }
}
