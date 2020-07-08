package com.shark.example.service.account;

import com.shark.example.dao.entity.AccountDaoEntity;
import com.shark.example.dao.mapper.AccountMapper;
import com.shark.example.dao.repository.AccountRepository;
import com.shark.example.service.account.dio.RegisterInput;
import com.shark.example.service.base.BaseResponseEntity;
import com.shark.example.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@RequiredArgsConstructor
@Service("RegisterService")
public class RegisterService extends BaseService<RegisterInput, BaseResponseEntity<AccountDaoEntity>> {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final MessageSource messageSource;

    @Override
    public BaseResponseEntity<AccountDaoEntity> start(RegisterInput registerInput) {
        BaseResponseEntity<AccountDaoEntity> response = new BaseResponseEntity<>();
        if(accountRepository.findByAccount(registerInput.getAccount()) != null) {
            response.setSuccess(false);
            response.setErrorMessage(messageSource.getMessage("account.exist", null, getLocale()));
            return response;
        }
        AccountDaoEntity accountDaoEntity = new AccountDaoEntity();
        accountDaoEntity.setAccount(registerInput.getAccount());
        accountDaoEntity.setName(registerInput.getAccount());
        accountDaoEntity.setPassword(registerInput.getPassword());
        accountMapper.insertAccount(accountDaoEntity);
        return response;
    }
}
