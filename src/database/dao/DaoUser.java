package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import database.connection.ConnectionFactory;
import model.Login;
import model.Platform;
import model.User;
import utils.SqlUtil;

public class DaoUser implements DaoInterface<User> {
	Connection connection;
	PreparedStatement preparedStatement;
	
	
	@Override
	public boolean add(User user) {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryAdd("user", "name", "email" ,"user_login_id", "user_platform_id");
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, user.getName());
			preparedStatement.setString(count++, user.getEmail());
			preparedStatement.setInt(count++, user.getLogin().getId());
			preparedStatement.setInt(count++, user.getPlatform().getId());
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
        String sql = SqlUtil.buildQueryDelete("user", "id_user");
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
	public boolean update(User user) {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryUpdate("user", "name", "email", "id_user");
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(count++, user.getName());
			preparedStatement.setString(count++, user.getEmail());
			preparedStatement.setInt(count++, user.getId());
			return preparedStatement.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.fecharConexao();
		}

		return false;
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public static void main(String[] args) {
		Platform platform = new Platform();
		Login loginPlatform = new Login();
		loginPlatform.setId(1);
		loginPlatform.setPassword("bla");
		loginPlatform.setUsername("bla2");
		
		platform.setId(1);
		platform.setNome("Opera");
		platform.setLogin(loginPlatform);
		
		platform.setImagem("http://imagem.exemplo");
		
		Login loginUser = new Login();
		loginUser.setId(1);
		loginUser.setPassword("blauser");
		loginUser.setUsername("blaUseerrr");
		
		User user = new User();
		user.setName("John DoeAMANO");
		user.setEmail("johndoe@gmail.com");
		user.setId(1);
		user.setLogin(loginUser);
		user.setPlatform(platform);

		DaoUser daoUser = new DaoUser();
		daoUser.update(user);
		
		
		
		
		
		
	}

	
	
}
