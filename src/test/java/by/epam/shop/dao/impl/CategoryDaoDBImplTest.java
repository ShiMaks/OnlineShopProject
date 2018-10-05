package by.epam.shop.dao.impl;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.domain.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.epam.shop.dao.util.TablesColumnNamesDeclaration.CATEGORY_COLUMN_ID;
import static by.epam.shop.dao.util.TablesColumnNamesDeclaration.CATEGORY_COLUMN_NAME;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CategoryDaoDBImplTest {

    private ConnectionPool pool;
    private CategoryDaoDBImpl dao;

    @Before
    public void setUp() {
        pool = mock(ConnectionPool.class);
        dao = new CategoryDaoDBImpl(pool);
    }

    @Test
    public void testMapRow() throws DaoException, SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt(CATEGORY_COLUMN_ID)).thenReturn(1);
        when(rs.getString(CATEGORY_COLUMN_NAME)).thenReturn("test category");

        Category category = dao.mapRow(rs);

        Assert.assertNotNull(category);
        Assert.assertEquals(category.getId(), 1);
        Assert.assertEquals(category.getName(), "test category");
    }

    @Test(expected = DaoException.class)
    public void testMapRow_SQLException() throws SQLException, DaoException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt(CATEGORY_COLUMN_ID)).thenThrow(new SQLException("error"));
        dao.mapRow(rs);
    }

    @Test
    public void testCreate() throws DaoException, SQLException {
        Connection connection = mock(Connection.class);
        when(pool.getConnection()).thenReturn(connection);

        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);

        Category category = new Category();
        category.setName("test");
        dao.create(category);

        verify(preparedStatement, times(1)).setString(1, "test");
        verify(preparedStatement, times(1)).executeUpdate();
        verify(pool, atLeastOnce()).returnConnection(connection);
    }

    @Test
    public void testCreate_Error() throws DaoException, SQLException {
        Connection connection = mock(Connection.class);
        when(pool.getConnection()).thenReturn(connection);

        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(any(String.class))).thenThrow(new RuntimeException("problem"));

        try {
            Category category = new Category();
            category.setName("test");
            dao.create(category);


        } catch (Exception e) {
            e.printStackTrace();

            verify(preparedStatement, never()).setString(1, "test");
            verify(preparedStatement, never()).executeUpdate();
            verify(pool, atLeastOnce()).returnConnection(connection);

            return;
        }

        Assert.fail("No exception thrown but we expected");
    }
}
