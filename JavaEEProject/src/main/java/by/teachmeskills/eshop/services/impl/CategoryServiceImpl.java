package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.impl.CategoryDaoImpl;
import by.teachmeskills.eshop.domain.entities.Category;
import by.teachmeskills.eshop.services.ICategoryService;

import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements ICategoryService {

    private final CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    @Override
    public void create(Category entity) throws Exception {
        categoryDao.create(entity);
    }

    @Override
    public List<Category> read() throws Exception {
        return categoryDao.read();
    }

    @Override
    public void update(Category entity) throws Exception {
        categoryDao.update(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        categoryDao.delete(id);
    }
}
