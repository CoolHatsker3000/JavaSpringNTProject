package DAO;

import DAO.interfaces.UserDAO;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class UserDAOImpl implements UserDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    public List<UserEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM USERS", new RowMapper<UserEntity>() {
            public UserEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                return new UserEntity(rs.getLong("USER_ID"),rs.getFloat("USER_BALANCE"));
            }
        });
    }

    public UserEntity get(long id) {
        try {
            String SQL = "SELECT * FROM USERS WHERE USER_ID=?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id},
                    new RowMapper<UserEntity>() {
                        public UserEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                            return new UserEntity(rs.getInt("USER_ID"), rs.getFloat("USER_BALANCE"));
                        }
                    });
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }


    public boolean add(UserEntity userEntity) {
        String SQL="INSERT  INTO USERS VALUES(?, ?)";
        jdbcTemplate.update(SQL,userEntity.getUser_id(),userEntity.getUser_balance());
        return true;
    }

    public boolean del(UserEntity userEntity) {
        String SQL="DELETE FROM USERS WHERE USER_ID=?";
        jdbcTemplate.update(SQL,userEntity.getUser_id());
        return true;
    }

    public boolean update(UserEntity userEntity) {
        String SQL="UPDATE USERS SET USER_BALANCE=? WHERE USER_ID=?";
        jdbcTemplate.update(SQL,userEntity.getUser_balance(),userEntity.getUser_id());
        return true;
    }
}
