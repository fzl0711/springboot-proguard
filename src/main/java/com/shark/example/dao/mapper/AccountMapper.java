package com.shark.example.dao.mapper;

import com.shark.example.dao.entity.AccountDaoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository("AccountMapper")
public interface AccountMapper {
    @Insert("insert into ACCOUNT (ACCOUNT, NAME, PASSWORD) values (#{account}, #{name}, #{password})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insertAccount(AccountDaoEntity accountDaoEntity);
}