package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.connection.ConnectionFactory;
import model.Login;
import utils.SqlUtil;

public class DaoLogin implements DaoInterface<Login> {

	Connection connection;
	PreparedStatement preparedStatement;

	@Override
	public boolean add(Login login) {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryAdd("login", "username", "password");
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, login.getUsername());
			preparedStatement.setString(count++, login.getPassword());
			return preparedStatement.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao();
		}

		return false;
	}

	@Override
	public boolean removeById(Integer id) {
	      	connection = ConnectionFactory.obterConexao();
	        String sql = SqlUtil.buildQueryDelete("login", "id_login");
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, id);
	            return preparedStatement.executeUpdate() == 1;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            ConnectionFactory.fecharConexao();
	        }
	        return false;
	}

	@Override
	public boolean update(Login login) {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryUpdate("login", "username", "password", "id_login");
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, login.getUsername());
			preparedStatement.setString(count++, login.getPassword());
			preparedStatement.setInt(count++, login.getId());
			return preparedStatement.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao();
		}

		return false;

	}

	@Override
	public List<Login> getAll() {
		   List<Login> logins = new ArrayList<>();
	        connection = ConnectionFactory.obterConexao();
	        String sql = SqlUtil.buildQueryGetAll("login");
	        try {
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.execute();
	            ResultSet resultSet = preparedStatement.getResultSet();
	            while (resultSet.next()) {
	                Login login = new Login();
	                login.setId(resultSet.getInt("id_login"));
	                login.setUsername(resultSet.getString("username"));
	                login.setPassword(resultSet.getString("password"));
	                logins.add(login);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            ConnectionFactory.fecharConexao();
	        }
	        return logins;
		
	}
	
	public static void main(String[] args) {
		Login loginUser = new Login();
		loginUser.setPassword("bldsldslds");
		loginUser.setUsername("sdkdsldsl");
		
		
		loginUser.setPassword("bldsldsld3223s");
		loginUser.setUsername("sdkdsldsl323");
		
		DaoLogin daoLogin = new DaoLogin();
		
		daoLogin.add(loginUser);
		
		}

}
