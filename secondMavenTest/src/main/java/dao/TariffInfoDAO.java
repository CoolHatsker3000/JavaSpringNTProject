package dao;

import entity.TariffInfoEntity;
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
import java.util.List;

@Component
public class TariffInfoDAO extends OperationsServiceImpl<TariffInfoEntity> {

    private static RowMapper<TariffInfoEntity> rowMapper = new RowMapper<TariffInfoEntity>() {
        public TariffInfoEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new TariffInfoEntity(resultSet.getInt("TARIFF_ID"), resultSet.getInt("ATTR_ID"), resultSet.getString("ATTR_V"));
        }
    };

    private static TabMapper tabMapper=new TabMapper("TARIFF_INFO",new String[]{"TARIFF_ID", "ATTR_ID"},new String[]{"ATTR_V"});
    @Autowired
    public TariffInfoDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rowMapper, tabMapper);
    }



    Object[] getDataToCreate(TariffInfoEntity obj) {
        return new Object[] {obj.getTariffId(), obj.getAttrId(), obj.getAttrV()};
    }

    Object[] getDataToUpdate(TariffInfoEntity obj) {
        return new Object[] {obj.getAttrV(),obj.getTariffId(),obj.getAttrId()};
    }

    public List<TariffInfoEntity> getInfoById(int tariffId){
        String sql=QueryConstructor.getSelectByID(new TabMapper("TARIFF_INFO",new String[]{"TARIFF_ID"},new String[]{}));
        return this.jdbcTemplate.query(sql,new Object[] {tariffId},rowMapper);
    }
    public void deleteInfoAboutTariff(int tariffId){
        String sql=QueryConstructor.getDelete(new TabMapper("TARIFF_INFO",new String[]{"TARIFF_ID"},new String[] {}));
        System.out.println(sql);
        this.jdbcTemplate.update(sql,new Object[] {tariffId});
    }
}
