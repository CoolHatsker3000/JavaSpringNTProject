package dao;

import entity.TariffAttrEntity;
import mappers.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class TariffAttrDAO extends OperationsServiceImpl<TariffAttrEntity> {

    private static RowMapper<TariffAttrEntity> rowMapper=new RowMapper<TariffAttrEntity>() {
        public TariffAttrEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new TariffAttrEntity(resultSet.getInt("ATTR_ID"), resultSet.getString("ATTR_NAME"));
        }
    };
    private static  TabMapper tabMapper = new TabMapper("TARIFF_ATTRS", new String[]{"ATTR_ID"}, new String[]{"ATTR_NAME"});

    @Autowired
    public TariffAttrDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rowMapper, tabMapper);
    }

    Object[] getDataToCreate(TariffAttrEntity obj) {
        return new Object[]{obj.getAttrId(), obj.getAttrName()};
    }

    Object[] getDataToUpdate(TariffAttrEntity obj) {
        return new Object[]{obj.getAttrName()};
    }
}
