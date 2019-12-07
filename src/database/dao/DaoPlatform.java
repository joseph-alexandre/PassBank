package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.connection.ConnectionFactory;
import model.Platform;
import model.User;
import utils.SqlUtil;

public class DaoPlatform implements DaoInterface<Platform> {

	Connection connection;
	PreparedStatement preparedStatement;

	@Override
	public boolean add(Platform platform) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryAdd("platform", "name", "image", "username", "password");
		
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, platform.getName());
			preparedStatement.setString(count++, platform.getImage());
			preparedStatement.setString(count++, platform.getUsername());
			preparedStatement.setString(count++, platform.getPassword());
			return preparedStatement.executeUpdate() == 1;
		
	}

	@Override
	public boolean removeById(Integer id)  throws SQLException{
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryDelete("platform", "id_platform");
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate() == 1;
			
	}

	@Override
	public boolean update(Platform platform) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryUpdate("platform", "name", "image", "username", "password");
		
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, platform.getName());
			preparedStatement.setString(count++, platform.getImage());
			preparedStatement.setString(count++, platform.getUsername());
			preparedStatement.setString(count++, platform.getPassword());
			return preparedStatement.executeUpdate() == 1;
	}

	@Override
	public List<Platform> getAll() throws SQLException {
		List<Platform> platforms = new ArrayList<>();
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryGetAllOrById("platform");
		
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				Platform platform = new Platform();
				platform.setId(resultSet.getInt("id_platform"));
				platform.setName(resultSet.getString("name"));
				platform.setImage(resultSet.getString("image"));
				platform.setUsername("username");
				platform.setPassword("password");
				platforms.add(platform);
			}
		return platforms;

	}

	@Override
	public Platform getById(Integer id) throws SQLException {

		Platform platform = new Platform();
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryGetAllOrById("platform", "id_platform", id);
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		ResultSet resultSet = preparedStatement.getResultSet();
		while (resultSet.next()) {
			platform.setId(resultSet.getInt("id_platform"));
			platform.setName(resultSet.getString("name"));
			platform.setImage(resultSet.getString("image"));
			platform.setUsername(resultSet.getString("username"));
			platform.setPassword(resultSet.getString("password"));
			return platform;
		}

		return null;
	}
	
	
	
	
	public static void main(String[] args) {
	
		DaoPlatform daoPlatform = new DaoPlatform();
		try {
			System.out.println(daoPlatform.getById(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
