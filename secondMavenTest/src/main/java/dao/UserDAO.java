package dao;

import dao.interfaces.OperationsService;
import entity.UserEntity;
import mappers.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserDAO extends OperationsServiceImpl<UserEntity> {
    private static RowMapper<UserEntity> rm= new RowMapper<UserEntity>(){

        public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new UserEntity(resultSet.getLong("USER_ID"), resultSet.getFloat("USER_BALANCE"));
        }
    };
    private static TabMapper tm=new TabMapper("USERS", new String[] {"USER_ID"},new String[]{"USER_BALANCE"});

    @Autowired
    public UserDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rm, tm);

    }

    Object[] getDataToCreate(UserEntity obj) {
        return new Object[] {obj.getUserId(), obj.getUserBalance()};
    }

    Object[] getDataToUpdate(UserEntity obj) {
        return new Object[] {obj.getUserBalance()};
    }
}
