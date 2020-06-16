package spring;

import java.util.Arrays;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import entity.FeeFrozenRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import spring.config.DataSourceConfigProperties;
import spring.dao.FeeFrozenRecordMapper;

@SpringBootApplication
@EnableConfigurationProperties(DataSourceConfigProperties.class)
@MapperScan("spring.dao")
@NacosPropertySource(dataId = "payinterface", autoRefreshed = true)
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        DataSourceConfigProperties bean = run.getBean(DataSourceConfigProperties.class);
        System.out.println(bean);
        bean.setPassword("123");
        System.out.println(run.getBean("commandLineRunner"));
       /* FeeFrozenRecord feeFrozenRecord = bean.selectById("BDF8BSVD2LFGUJGM00JG");
        System.out.println(feeFrozenRecord);
        feeFrozenRecord.setRecordStatus("0001");
        bean.updateByPrimaryKey(feeFrozenRecord);*/
        System.out.println("end");


    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.print(beanName+",");
            }

        };
    }

}