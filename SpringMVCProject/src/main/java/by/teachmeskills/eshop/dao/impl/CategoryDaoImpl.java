package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.ICategoryDao;
import by.teachmeskills.eshop.domain.entities.Category;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.eshop.utils.EshopConstants.DESCRIPTION;
import static by.teachmeskills.eshop.utils.EshopConstants.ID;
import static by.teachmeskills.eshop.utils.EshopConstants.IMG;
import static by.teachmeskills.eshop.utils.EshopConstants.NAME;

@Repository
public class CategoryDaoImpl implements ICategoryDao {
    private static final String GET_ALL_CATEGORIES_QUERY = "SELECT * FROM CATEGORIES";
    private static final String CREATE_CATEGORY_QUERY = "INSERT INTO CATEGORISE (NAME, DESCRIPTION, IMG) VALUE (?, ?, ?)";
    private static final String UPDATE_CATEGORY_QUERY = "UPDATE CATEGORIES SET NAME=?, DESCRIPTION=?, IMG=? WHERE ID=?";
    private static final String DELETE_CATEGORY_QUERY = "DELETE FROM CATEGORIES WHERE id=?";

    @Override
    public void create(Category category) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CATEGORY_QUERY);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setString(3, category.getImg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
    }

    @Override
    public List<Category> read() throws Exception {
        List<Category> categories = new ArrayList<>();
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(ID));
                String name = rs.getString(NAME);
                String description = rs.getString(DESCRIPTION);
                String img = rs.getString(IMG);
                categories.add(Category.builder()
                        .id(id)
                        .description(description)
                        .img(img)
                        .productList(new ArrayList<>())
                        .name(name)
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public void update(Category category) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_QUERY);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setString(3, category.getImg());
            preparedStatement.setString(4, String.valueOf(category.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_QUERY);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
    }
}
