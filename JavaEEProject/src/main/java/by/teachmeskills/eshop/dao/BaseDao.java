package by.teachmeskills.eshop.dao;

import by.teachmeskills.eshop.domain.entities.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {

    ConnectionPool pool = ConnectionPool.getInstance();

    void create(T entity) throws Exception;

    List<T> read() throws Exception;

    void update(T entity) throws Exception;

    void delete(int id) throws Exception;
}
