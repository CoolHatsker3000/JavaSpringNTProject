package dao;

import dao.interfaces.OperationsService;
import mappers.TabMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utilities.QueryConstructor;


import java.util.List;
public abstract class OperationsServiceImpl<T> implements OperationsService<T> {
    protected final JdbcTemplate jdbcTemplate;
    private final RowMapper<T> rowMapper;
    private final TabMapper tabMapper;

    abstract Object[] getDataToCreate(T obj);
    abstract Object[] getDataToUpdate(T obj);


    public OperationsServiceImpl(JdbcTemplate jdbcTemplate, RowMapper<T> rowMapper, TabMapper tabMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
        this.tabMapper=tabMapper;
    }

    public List<T> getAll() {
        String sql = QueryConstructor.getSelectAll(tabMapper);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public T getByID(long id) {
        String sql=QueryConstructor.getSelectByID(tabMapper);
        try {
            return jdbcTemplate.queryForObject(sql,new Object[]{id}, rowMapper);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public T getByID(Long[] ids){
        String sql=QueryConstructor.getSelectByID(tabMapper);
        try {
            return jdbcTemplate.queryForObject(sql,ids, rowMapper);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    /*
    public T find(T toFind){
        String sql=QueryConstructor.getFind(tabMapper);

    }
    */
    public void create(T toCreate) {
        String sql =QueryConstructor.getInsert(tabMapper);
        Object[] createData=getDataToCreate(toCreate);
        jdbcTemplate.update(sql, createData);
    }

    public void update(T toUpdate) {
        String sql=QueryConstructor.getUpdate(tabMapper);
        Object[] updateData=getDataToUpdate(toUpdate);
        jdbcTemplate.update(sql, updateData);
    }

    public void delete(long id) {
        String sql=QueryConstructor.getDelete(tabMapper);
        jdbcTemplate.update(sql,id);
    }
    public void delete(Object[] IDs){
        String sql=QueryConstructor.getDelete(tabMapper);
        jdbcTemplate.update(sql,IDs);
    }
}
