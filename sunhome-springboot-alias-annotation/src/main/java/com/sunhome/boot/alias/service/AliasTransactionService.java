package com.sunhome.boot.alias.service;

import com.sunhome.boot.alias.annotation.TransactionalService;

@TransactionalService(txManager = "txManager")
public class AliasTransactionService {


    public void delete() {
        System.out.println("delete .....................");

    }
}