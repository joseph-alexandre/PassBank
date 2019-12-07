package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.connection.ConnectionFactory;
import model.Record;
import utils.SqlUtil;

public class DaoRecord implements DaoInterface<Record> {

	Connection connection;
	PreparedStatement preparedStatement;

	@Override
	public boolean add(Record record) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryAdd("record", "id_platform", "id_user");

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(count++, record.getId_platform());
		preparedStatement.setInt(count++, record.getId_user());
		return preparedStatement.executeUpdate() == 1;

	}

	@Override
	public boolean removeById(Integer id) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryDelete("record", "id_record");

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		return preparedStatement.executeUpdate() == 1;
	}

	@Override
	public boolean update(Record record) throws SQLException {
		connection = ConnectionFactory.obterConexao();
		int count = 1;
		String sql = SqlUtil.buildQueryUpdate("record", "id_platform", "id_user");

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(count++, record.getId_platform());
		preparedStatement.setInt(count++, record.getId_user());
		return preparedStatement.executeUpdate() == 1;

	}

	@Override
	public List<Record> getAll() throws SQLException {
		List<Record> records = new ArrayList<>();
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryGetAllOrById("record");

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		ResultSet resultSet = preparedStatement.getResultSet();
		while (resultSet.next()) {
			Record record = new Record();
			record.setId(resultSet.getInt("id_record"));
			record.setId_platform(resultSet.getInt("id_platform"));
			record.setId_user(resultSet.getInt("id_user"));
			records.add(record);
		}

		return records;

	}

	@Override
	public Record getById(Integer id) throws SQLException {
		Record record = new Record();
		connection = ConnectionFactory.obterConexao();
		String sql = SqlUtil.buildQueryGetAllOrById("record", "id_record", id);

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		ResultSet resultSet = preparedStatement.getResultSet();
		while (resultSet.next()) {
			record.setId(resultSet.getInt("id_record"));
			record.setId_platform(resultSet.getInt("id_platform"));
			record.setId_user(resultSet.getInt("id_user"));
			return record;
		}

		return null;
	}

}
