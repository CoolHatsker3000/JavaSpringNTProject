package DAO;

import DAO.interfaces.TariffAttrDAO;
import entity.TariffAttrEntity;
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
public class TariffAttrDAOImpl implements TariffAttrDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public List<TariffAttrEntity> getAll() {
        return jdbcTemplate.query("SELECT * FROM TARIFF_ATTRS", new RowMapper<TariffAttrEntity>() {
            public TariffAttrEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
            return new TariffAttrEntity(rs.getInt("ATTR_ID"),rs.getString("ATTR_NAME"));
            }
        });
    }

    public TariffAttrEntity get(int id) {
        String SQL="SELECT * FROM TARIFF_ATTRS WHERE ATTR_ID=?";
        try {
            return jdbcTemplate.queryForObject(SQL, new Object[]{id},
                    new RowMapper<TariffAttrEntity>() {
                        public TariffAttrEntity mapRow(ResultSet rs, int RowNum) throws SQLException {
                            return new TariffAttrEntity(rs.getInt("ATTR_ID"), rs.getString("ATTR_NAME"));
                        }
                    });
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public boolean add(TariffAttrEntity tariffAttrEntity) {
        String SQL="INSERT INTO TARIFF_ATTRS VALUES(? ?)";
        jdbcTemplate.update(SQL,tariffAttrEntity.getAttr_id(),tariffAttrEntity.getAttr_name());
        return true;
    }

    public boolean del(TariffAttrEntity tariffAttrEntity) {
        String SQL="DELETE FROM TARIFF_ATTRS WHERE ATTR_ID=?";
        jdbcTemplate.update(SQL,tariffAttrEntity.getAttr_id());
        return true;
    }

    public boolean update(TariffAttrEntity tariffAttrEntity) {
        String SQL="UPDATE TARIFF_ATTRS SET ATTR_NAME=? WHERE ATTR_ID=?";
        jdbcTemplate.update(SQL,tariffAttrEntity.getAttr_name(),tariffAttrEntity.getAttr_id());
        return true;
    }
}
