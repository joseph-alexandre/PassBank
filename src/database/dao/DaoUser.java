package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.connection.ConnectionFactory;
import model.User;
import utils.SqlUtil;

public class DaoUser implements DaoInterface<User> {
	Connection connection;
	PreparedStatement preparedStatement;

	@Override
	public boolean add(User user) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryAdd("user", "name", "email", "username", "password");

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(count++, user.getName());
		preparedStatement.setString(count++, user.getEmail());
		preparedStatement.setString(count++, user.getUsername());
		preparedStatement.setString(count++, user.getPassword());
		return preparedStatement.executeUpdate() == 1;

	}

	@Override
	public boolean removeById(Integer id) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryDelete("user", "id_user");

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate() == 1;

	}

	@Override
	public boolean update(User user) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryUpdate("user", "name", "username", "password", "id_user");

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(count++, user.getName());
		preparedStatement.setString(count++, user.getUsername());
		preparedStatement.setString(count++, user.getPassword());
		preparedStatement.setInt(count++, user.getId());
		return preparedStatement.executeUpdate() == 1;

	}

	@Override
	public List<User> getAll() throws SQLException {
		List<User> users = new ArrayList<>();
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryGetAllOrById("user");

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		ResultSet resultSet = preparedStatement.getResultSet();
		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt("id_user"));
			user.setName(resultSet.getString("name"));
			user.setEmail(resultSet.getString("email"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			users.add(user);
		}

		return users;

	}

	@Override
	public User getById(Integer id) throws SQLException {
		User user = new User();
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryGetAllOrById("user", "id_user", id);
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		ResultSet resultSet = preparedStatement.getResultSet();
		while (resultSet.next()) {
			user.setId(resultSet.getInt("id_user"));
			user.setName(resultSet.getString("name"));
			user.setEmail(resultSet.getString("email"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			return user;
		}

		return null;
	}
	
}
