package dao;

import dao.interfaces.OperationsService;
import mappers.TabMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utilities.QueryConstructor;


import java.util.List;
public abstract class OperationsServiceImpl<T> implements OperationsService<T> {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<T> rm;
    private final TabMapper tm;

    abstract Object[] getDataToCreate(T obj);
    abstract Object[] getDataToUpdate(T obj);


    public OperationsServiceImpl(JdbcTemplate jdbcTemplate, RowMapper<T> rm, TabMapper tm) {
        this.jdbcTemplate = jdbcTemplate;
        this.rm = rm;
        this.tm=tm;
    }

    public List<T> getAll() {
        String sql = QueryConstructor.getSelectAll(tm);
        return jdbcTemplate.query(sql, rm);
    }

    public T getByID(long id) {
        String sql=QueryConstructor.getSelectByID(tm);
        try {
            return jdbcTemplate.queryForObject(sql,new Object[]{id}, rm);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public void create(T toCreate) {
        String sql =QueryConstructor.getInsert(tm);
        System.out.println(sql);
        Object[] createData=getDataToCreate(toCreate);
        jdbcTemplate.update(sql, createData);
    }

    public void update(T toUpdate) {
        String sql=QueryConstructor.getUpdate(tm);
        Object[] updateData=getDataToUpdate(toUpdate);
        jdbcTemplate.update(sql, updateData);
    }

    public void delete(long id) {
        String sql=QueryConstructor.getDelete(tm);
        jdbcTemplate.update(sql,id);
    }
}
