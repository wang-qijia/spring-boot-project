//package com.sunhome.boot.annotation;
//
//import org.springframework.core.annotation.AliasFor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.lang.annotation.*;
//
//@Target({ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Service
//@Transactional
//public @interface TransactionalService {
//
//    @AliasFor(annotation = Transactional.class, attribute = "transactionManager")
//    String txManager() default "txManager";
//}
