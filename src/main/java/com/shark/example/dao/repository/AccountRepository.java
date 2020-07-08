package com.shark.example.dao.repository;

import com.shark.example.dao.entity.AccountDaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AccountRepository")
public interface AccountRepository extends JpaRepository<AccountDaoEntity, Long> {

    AccountDaoEntity findByAccount(String account);
    Page<AccountDaoEntity> findByNameContaining(String name, Pageable pageable);
}
