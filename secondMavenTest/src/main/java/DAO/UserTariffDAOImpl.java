package DAO;

import DAO.interfaces.UserTariffDAO;
import entity.UserTariffEntity;
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
public class UserTariffDAOImpl implements UserTariffDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public List<UserTariffEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM USER_TARIFF", new RowMapper<UserTariffEntity>() {
            public UserTariffEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                return new UserTariffEntity(
                        rs.getLong("USER_ID"),
                        rs.getInt("TARIFF_ID"));
            }
        });
    }

    public UserTariffEntity getTariffByUserID(long user_id) {
        String SQL="SELECT * FROM USER_TARIFF WHERE USER_ID=?";
        try {
            return jdbcTemplate.queryForObject(SQL, new Object[]{user_id},
                    new RowMapper<UserTariffEntity>() {
                        public UserTariffEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                            return new UserTariffEntity(
                                    rs.getLong("USER_ID"),
                                    rs.getInt("TARIFF_ID"));
                        }
                    });
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    public List<UserTariffEntity> getUsersByTariffID(int tariff_id) {
            return jdbcTemplate.query("SELECT * FROM USER_TARIFF WHERE TARIFF_ID=?", new Object[]{tariff_id}, new RowMapper<UserTariffEntity>() {
                public UserTariffEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                    return new UserTariffEntity(
                            rs.getLong("USER_ID"),
                            rs.getInt("TARIFF_ID"));
                }
            });
    }

    public boolean isIn(long user_id, int tariff_id) {
        UserTariffEntity ute=getTariffByUserID(user_id);
        if (ute==null) return false;
        return (ute.getTariff_id()==tariff_id);
    }

    public boolean add(UserTariffEntity tariffInfoEntity) {
        String SQL="INSERT INTO USER_TARIFF VALUES(?, ?)";
        jdbcTemplate.update(SQL, tariffInfoEntity.getUser_id(),tariffInfoEntity.getTariff_id());
        return true;
    }

    public boolean del(UserTariffEntity tariffInfoEntity) {
        String SQL="DELETE FROM USER_TARIFF WHERE USER_ID=?";
        jdbcTemplate.update(SQL,tariffInfoEntity.getUser_id());
        return true;
    }

    public boolean update(UserTariffEntity tariffInfoEntity) {
        String SQL="UPDATE USER_TARIFF SET TARIFF_ID=? WHERE USER_ID=?";
        jdbcTemplate.update(SQL,tariffInfoEntity.getTariff_id(),tariffInfoEntity.getUser_id());
        return true;
    }
}
