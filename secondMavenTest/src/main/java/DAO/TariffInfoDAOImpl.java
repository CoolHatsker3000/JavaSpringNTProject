package DAO;

import DAO.interfaces.TariffInfoDAO;
import entity.TariffInfoEntity;
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
public class TariffInfoDAOImpl implements TariffInfoDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }


    public List<TariffInfoEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM TARIFF_INFO", new RowMapper<TariffInfoEntity>() {
            public TariffInfoEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                return new TariffInfoEntity(
                        rs.getInt("TARIFF_ID"),
                        rs.getInt("ATTR_ID"),
                        rs.getString("TARIFF_NAME"));
            }
        });
    }

    public TariffInfoEntity get(int tariff_id,int attr_id) {
        String SQL="SELECT * FROM TARIFF_INFO WHERE TARIFF_ID=? AND ATTR_ID=?";
        try {
            return jdbcTemplate.queryForObject(SQL, new Object[]{tariff_id, attr_id},
                    new RowMapper<TariffInfoEntity>() {
                        public TariffInfoEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                            return new TariffInfoEntity(
                                    rs.getInt("TARIFF_ID"),
                                    rs.getInt("ATTR_ID"),
                                    rs.getString("TARIFF_NAME"));
                        }
                    });
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public boolean add(TariffInfoEntity tariffInfoEntity) {
        String SQL="INSERT INTO TARIFF_INFO VALUES(?, ?, ?)";
        jdbcTemplate.update(SQL,tariffInfoEntity.getTariff_id(),tariffInfoEntity.getAttr_id(),tariffInfoEntity.getAttr_v());
        return true;
    }

    public boolean del(TariffInfoEntity tariffInfoEntity) {
        String SQL="DELETE FROM TARIFF_INFO WHERE TARIFF_ID=? AND ATTR_ID=?";
        jdbcTemplate.update(SQL,tariffInfoEntity.getTariff_id(),tariffInfoEntity.getAttr_id());
        return true;
    }

    public boolean del(int tariff_id, int attr_id) {
        String SQL="DELETE FROM TARIFF_INFO WHERE TARIFF_ID=? AND ATTR_ID=?";
        jdbcTemplate.update(SQL,tariff_id,tariff_id);
        return true;
    }

    public boolean update(TariffInfoEntity tariffInfoEntity) {
        String SQL="UPDATE TARIFF_INFO SET ATTR_V=? WHERE TARIFF_ID=? and ATTR_ID=?";
        jdbcTemplate.update(SQL,tariffInfoEntity.getAttr_v(),tariffInfoEntity.getTariff_id(),tariffInfoEntity.getAttr_id());
        return true;
    }
}
