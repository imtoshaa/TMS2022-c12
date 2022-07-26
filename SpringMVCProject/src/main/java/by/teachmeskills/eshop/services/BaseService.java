package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

  void create(T entity) throws Exception;

  List<T> read() throws Exception;

  void update(T entity) throws Exception;

  void delete(int id) throws Exception;
}
