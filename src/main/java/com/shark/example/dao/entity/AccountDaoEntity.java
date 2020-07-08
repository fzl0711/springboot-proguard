package com.shark.example.dao.entity;



import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
public class AccountDaoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name = "account", unique = true)
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;
}
