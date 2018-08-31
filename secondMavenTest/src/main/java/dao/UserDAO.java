package dao;

import dao.interfaces.OperationsService;
import entity.UserEntity;
import mappers.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import utilities.QueryConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UserDAO extends OperationsServiceImpl<UserEntity> {
    private static RowMapper<UserEntity> rowMapper= new RowMapper<UserEntity>(){

        public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new UserEntity(resultSet.getLong("USER_ID"),resultSet.getString("USER_PASSWORD"), resultSet.getFloat("USER_BALANCE"));
        }
    };
    private static TabMapper tabMapper=new TabMapper("USERS", new String[] {"USER_ID"},new String[]{"USER_PASSWORD","USER_BALANCE"});
    private static TabMapper tabMapperForFind=new TabMapper("USERS",new String[] {},new String[]{"USER_ID","USER_PASSWORD"});
    @Autowired
    public UserDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rowMapper, tabMapper);

    }

    Object[] getDataToCreate(UserEntity obj) {
        return new Object[] {obj.getUserId(),obj.getUserPassword(), obj.getUserBalance()};
    }

    Object[] getDataToUpdate(UserEntity obj) {
        return new Object[] {obj.getUserPassword(),obj.getUserBalance()};
    }

    public UserEntity selectUser(UserEntity userEntity){
        String sql=QueryConstructor.getSelect(tabMapperForFind);
        try {
            return this.jdbcTemplate.queryForObject(sql, new Object[]{userEntity.getUserId(), userEntity.getUserPassword()}, rowMapper);
        } catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
