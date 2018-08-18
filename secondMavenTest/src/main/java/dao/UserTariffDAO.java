package dao;

import entity.UserTariffEntity;
import mappers.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserTariffDAO extends OperationsServiceImpl<UserTariffEntity> {

    private static RowMapper<UserTariffEntity> rm=new RowMapper<UserTariffEntity>() {
        public UserTariffEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new UserTariffEntity(resultSet.getLong("USER_ID"), resultSet.getInt("TARIFF_ID"));
        }
    };

    private static TabMapper tm=new TabMapper("USER_TARIFF", new String[] {"USER_ID"},new String[]{"TARIFF_ID"});

    @Autowired
    public UserTariffDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rm, tm);
    }

    Object[] getDataToCreate(UserTariffEntity obj) {
        return new Object[] {"USER_ID", "TARIFF_ID"};
    }

    Object[] getDataToUpdate(UserTariffEntity obj) {
        return new Object[] {"TARIFF_ID"};
    }


}
