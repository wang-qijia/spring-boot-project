package com.sunhome.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@Configuration
public class TransactionalConfig {

    @Bean("txManager")
    public PlatformTransactionManager txManager() {

        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition transactionDefinition) throws TransactionException {
                return new SimpleTransactionStatus();
            }

            @Override
            public void commit(TransactionStatus transactionStatus) throws TransactionException {
                System.out.println("commit");
            }

            @Override
            public void rollback(TransactionStatus transactionStatus) throws TransactionException {
                System.out.println("rollback");

            }
        };
    }
}
