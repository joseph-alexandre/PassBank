package database.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoInterface<T> {

	public boolean add(T thing) throws SQLException;

	public boolean removeById(Integer id) throws SQLException;

	public boolean update(T thing) throws SQLException;

	public T getById(Integer id) throws SQLException;

	public List<T> getAll() throws SQLException;

}