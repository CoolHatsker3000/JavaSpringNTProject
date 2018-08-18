package dao.interfaces;

import java.util.List;

public interface OperationsService<T> {
    public List getAll();
    public Object getByID(long id);
    public void create(T toCreate);
    public void update(T toUpdate);
    public void delete(long id);
}
