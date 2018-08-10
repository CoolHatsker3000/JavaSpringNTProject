package test;

import entity.TariffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DBConnector {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    /*public void testfunc(){
        System.out.println("ITS WORKED");
    }*/

    public List getAll(){
        return jdbcTemplate.query("SELECT * FROM TARIFFS", new RowMapper<TariffEntity>() {
            public TariffEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                return new TariffEntity(rs.getInt("TARIFF_ID"),rs.getString("TARIFF_NAME"));
            }
        });
    }


}
