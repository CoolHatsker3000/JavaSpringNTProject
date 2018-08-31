package dao;

import entity.UserTariffEntity;
import mappers.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import utilities.QueryConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserTariffDAO extends OperationsServiceImpl<UserTariffEntity> {

    private static RowMapper<UserTariffEntity> rowMapper=new RowMapper<UserTariffEntity>() {
        public UserTariffEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new UserTariffEntity(resultSet.getLong("USER_ID"), resultSet.getInt("TARIFF_ID"));
        }
    };

    private static TabMapper tabMapper=new TabMapper("USER_TARIFF", new String[] {"USER_ID"},new String[]{"TARIFF_ID"});

    @Autowired
    public UserTariffDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rowMapper, tabMapper);
    }

    Object[] getDataToCreate(UserTariffEntity obj) {
        return new Object[] {obj.getUserId(),obj.getTariffId()};
    }

    Object[] getDataToUpdate(UserTariffEntity obj) {
        return new Object[] {obj.getTariffId(),obj.getUserId()};
    }

    public void UnsubscribeUsers(int tariffId){
        String sql=QueryConstructor.getDelete(new TabMapper("USER_TARIFF",new String[] {"TARIFF_ID"},new String[] {""}));
        System.out.println(sql);
        this.jdbcTemplate.update(sql,new Object[]{tariffId});
    }


}
