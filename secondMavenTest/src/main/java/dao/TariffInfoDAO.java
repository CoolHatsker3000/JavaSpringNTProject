package dao;

import entity.TariffInfoEntity;
import mappers.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class TariffInfoDAO extends OperationsServiceImpl<TariffInfoEntity> {

    private static RowMapper<TariffInfoEntity> rm = new RowMapper<TariffInfoEntity>() {
        public TariffInfoEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new TariffInfoEntity(resultSet.getInt("TARIFF_ID"), resultSet.getInt("ATTR_ID"), resultSet.getString("ATTR_V"));
        }
    };

    private static TabMapper tm=new TabMapper("TARIFF_INFO",new String[]{"TARIFF_ID", "ATTR_ID"},new String[]{"ATTR_V"});
    @Autowired
    public TariffInfoDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rm, tm);
    }

    Object[] getDataToCreate(TariffInfoEntity obj) {
        return new Object[] {obj.getTariffId(), obj.getAttrId(), obj.getAttrV()};
    }

    Object[] getDataToUpdate(TariffInfoEntity obj) {
        return new Object[] {obj.getAttrV()};
    }
}
