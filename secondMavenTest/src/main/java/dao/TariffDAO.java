package dao;

import entity.TariffEntity;
import mappers.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class TariffDAO extends OperationsServiceImpl<TariffEntity> {

    private static RowMapper<TariffEntity> rowMapper=new RowMapper<TariffEntity>() {
        public TariffEntity mapRow(ResultSet resultSet, int i) throws SQLException {
            return new TariffEntity(resultSet.getInt("TARIFF_ID"), resultSet.getString("TARIFF_NAME"));
        }
    };
    private static TabMapper tabMapper=new TabMapper("TARIFFS", new String[] {"TARIFF_ID"},new String[]{"TARIFF_NAME"});

    @Autowired
    public TariffDAO(DataSource dataSource) {
        super(new JdbcTemplate(dataSource), rowMapper, tabMapper);
    }

    Object[] getDataToCreate(TariffEntity obj) {
        return new Object[] {obj.getTariffId(), obj.getTariffName()};
    }

    Object[] getDataToUpdate(TariffEntity obj) {
        return new Object[] {obj.getTariffName()};
    }
}
