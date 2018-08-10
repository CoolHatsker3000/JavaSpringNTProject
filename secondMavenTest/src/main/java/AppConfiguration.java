import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"test", "dao"})
public class AppConfiguration {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dmds.setUrl("jdbc:oracle:thin://@localhost:1521/XE");
        System.out.println("jdbc:oracle:thin:@localhost:1521:XE");
        dmds.setUsername("ME");
        dmds.setPassword("ME");
        return dmds;
    }




}
