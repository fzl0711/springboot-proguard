package com.shark.example.service.account;

import com.google.gson.Gson;
import com.shark.example.dao.entity.AccountDaoEntity;
import com.shark.example.dao.repository.AccountRepository;
import com.shark.example.service.account.dio.SearchAccountInput;
import com.shark.example.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@RequiredArgsConstructor
@Service("SearchAccountListService")
public class SearchAccountListService extends BaseService<SearchAccountInput, Page<AccountDaoEntity>> {

    private final AccountRepository accountRepository;

    @Override
    public Page<AccountDaoEntity> start(SearchAccountInput searchAccountInput) {
        Pageable pageable = PageRequest.of(searchAccountInput.getPageNumber(), searchAccountInput.getPageSize());
        log.info("searchAccountInput: " + new Gson().toJson(searchAccountInput));
        if(StringUtils.isEmpty(searchAccountInput.getKeyword())) {
            log.info("findAll");
            return accountRepository.findAll(pageable);
        } else {
            return accountRepository.findByNameContaining(searchAccountInput.getKeyword(), pageable);
        }
    }
}
