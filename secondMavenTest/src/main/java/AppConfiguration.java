import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Locale;

@Configuration
@ComponentScan(basePackages = {"services","dao",})
public class AppConfiguration {
    @Bean
    public DataSource dataSource(){
        Locale.setDefault(Locale.ENGLISH);
        DriverManagerDataSource dmds = new DriverManagerDataSource();
        dmds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dmds.setUrl("jdbc:oracle:thin://@localhost:1521/XE");
        System.out.println("jdbc:oracle:thin:@localhost:1521:XE");
        dmds.setUsername("ME");
        dmds.setPassword("ME");
        return dmds;
    }




}
