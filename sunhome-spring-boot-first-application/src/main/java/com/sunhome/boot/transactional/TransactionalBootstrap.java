//package com.sunhome.boot.transactional;
//
//import com.sunhome.boot.annotation.TransactionalService;
//import org.springframework.util.ReflectionUtils;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.AnnotatedElement;
//
//@TransactionalService
//public class TransactionalBootstrap {
//
//    public static void main(String[] args) {
//
//        AnnotatedElement annotatedElement = TransactionalBootstrap.class;
//
//        TransactionalService transactionalService = annotatedElement.getAnnotation(TransactionalService.class);
//
//        ReflectionUtils.doWithMethods(TransactionalService.class, method -> {
//                    Object value = ReflectionUtils.invokeMethod(method, transactionalService);
//                    System.out.printf("@TransactionalService.%s()=%s\n", method.getName(), value);
//
//                }
//                , method -> !method.getDeclaringClass().equals(Annotation.class));
//
//    }
//}
