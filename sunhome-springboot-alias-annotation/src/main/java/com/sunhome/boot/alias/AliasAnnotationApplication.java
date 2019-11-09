package com.sunhome.boot.alias;


import com.sunhome.boot.alias.service.AliasService;
import com.sunhome.boot.alias.service.AliasTransactionService;
import com.sunhome.boot.alias.service.SecondAliasService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

@ComponentScan
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ConditionalOnNotWebApplication
public class AliasAnnotationApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AliasAnnotationApplication.class)
                .run(args)
                .close();

    }


    @Bean
    public CommandLineRunner print(ApplicationContext context) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // 隐形覆盖打印@SunhomeService默认名称
                Map<String, AliasService> beans = context.getBeansOfType(AliasService.class);

                beans.forEach((beaName, bean) -> {
                    System.out.println(beaName + ":" + bean.getClass().getName());
                });
                // 同注解中属性显性覆盖打印@SunhomeService默认名称
                Map<String, SecondAliasService> sechondBeans = context.getBeansOfType(SecondAliasService.class);

                sechondBeans.forEach((beaName, bean) -> {
                    System.out.println(beaName + ":" + bean.getClass().getName());
                });


                // 不同同注解中属性显性覆盖打印@TransactionalService默认名称t
                Map<String, AliasTransactionService> transactionBeans = context.getBeansOfType(AliasTransactionService.class);

                transactionBeans.forEach((beaName, bean) -> {
                    System.out.println(beaName + ":" + bean.getClass().getName());
                    // 执行 查看事务是否提交，若提交证明已显性覆盖
                    bean.delete();
                });


            }
        };
    }


}
