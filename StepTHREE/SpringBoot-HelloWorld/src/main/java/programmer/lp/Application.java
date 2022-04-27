package programmer.lp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBoot应用程序的入口

@SpringBootApplication

// 目前阶段，这样也可以
//@EnableAutoConfiguration
//@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
