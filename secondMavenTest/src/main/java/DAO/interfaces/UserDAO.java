package DAO.interfaces;

import entity.UserEntity;

import java.util.List;

public interface UserDAO {
    public List<UserEntity> getAll();
    public UserEntity get(long id);
    public boolean add(UserEntity userEntity);
    public boolean del(UserEntity userEntity);
    public boolean update(UserEntity userEntity);
}
