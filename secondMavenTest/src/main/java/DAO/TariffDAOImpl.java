package DAO;

import DAO.interfaces.TariffDAO;
import entity.TariffEntity;
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
public class TariffDAOImpl implements TariffDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public List<TariffEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM TARIFFS", new RowMapper<TariffEntity>() {
            public TariffEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                return new TariffEntity(rs.getInt("TARIFF_ID"),rs.getString("TARIFF_NAME"));
            }
        });
    }

    public TariffEntity get(int id) {
        String SQL="SELECT * FROM TARIFFS WHERE TARIFF_ID=?";
        try {
            return jdbcTemplate.queryForObject(SQL, new Object[]{id},
                    new RowMapper<TariffEntity>() {
                        public TariffEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                            return new TariffEntity(rs.getInt("TARIFF_ID"), rs.getString("TARIFF_NAME"));
                        }
                    });
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public boolean add(TariffEntity tariffEntity) {
        String SQL="INSERT INTO TARIFFS VALUES(?, ?)";
        jdbcTemplate.update(SQL,tariffEntity.getTariff_id(),tariffEntity.getTariff_name());
        return true;
    }

    public boolean del(TariffEntity tariffEntity) {
        String SQL="DELETE FROM TARIFFS WHERE TARIFF_ID=?";
        jdbcTemplate.update(SQL,tariffEntity.getTariff_id());
        return true;
    }

    public boolean del(int id) {
        String SQL="DELETE FROM TARIFFS WHERE TARIFF_ID=?";
        jdbcTemplate.update(SQL,id);
        return true;
    }

    public boolean update(TariffEntity tariffEntity) {
        String SQL="UPDATE TARIFFS SET TARIFF_NAME=? WHERE TARIFF_ID=?";
        jdbcTemplate.update(SQL,tariffEntity.getTariff_name(),tariffEntity.getTariff_id());
        return true;
    }
}
