package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.connection.ConnectionFactory;
import model.Login;
import model.Platform;
import utils.SqlUtil;

public class DaoPlatform implements DaoInterface<Platform> {

	Connection connection;
	PreparedStatement preparedStatement;

	@Override
	public boolean add(Platform platform) {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryAdd("platform", "name", "image", "id_login");
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, platform.getNome());
			preparedStatement.setString(count++, platform.getImagem());
			preparedStatement.setInt(count++, platform.getLogin().getId());
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
	        String sql = SqlUtil.buildQueryDelete("platform", "id_platform");
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
	public boolean update(Platform platform) {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryUpdate("platform", "name", "image", "id_login");
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, platform.getNome());
			preparedStatement.setString(count++, platform.getImagem());
			preparedStatement.setInt(count++, platform.getLogin().getId());
			return preparedStatement.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao();
		}

		return false;

	}

	@Override
	public List<Platform> getAll() {
		   List<Platform> logins = new ArrayList<>();
		   DaoLogin daoLogin = new DaoLogin();
	        connection = ConnectionFactory.obterConexao();
	        String sql = SqlUtil.buildQueryGetAll("platform");
	        try {
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.execute();
	            ResultSet resultSet = preparedStatement.getResultSet();
	            while (resultSet.next()) {
	                Platform platform = new Platform();
	                platform.setId(resultSet.getInt("id_platform"));
	                platform.setNome(resultSet.getString("name"));
	                platform.setImagem(resultSet.getString("image"));
	                platform.setLogin(daoLogin.);
	                logins.add(login);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            ConnectionFactory.fecharConexao();
	        }
	        return logins;
		
	}

}
