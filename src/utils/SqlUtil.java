package utils;

import java.util.Arrays;
import java.util.List;

public class SqlUtil {

	public static String buildQueryAdd(String tableName, String... attributes) {
		String sql = "INSERT INTO " + tableName + " " + buildAttributes(attributes) + " VALUES "
				+ buildAttributesQuestionMark(attributes);
		return sql;
	}

	public static String buildAttributes(String... attributes) {

		StringBuilder stringBuilder = new StringBuilder().append("(");

		for (int i = 0; i < attributes.length; i++) {
			stringBuilder.append(attributes[i] + ", ");
		}

		stringBuilder.delete(stringBuilder.lastIndexOf(", "), stringBuilder.length());
		stringBuilder.append(")");

		return stringBuilder.toString();
	}

	public static String buildAttributesQuestionMark(String... attributes) {

		StringBuilder stringBuilder = new StringBuilder().append("(");

		for (int i = 0; i < attributes.length; i++) {
			stringBuilder.append("?, ");
		}

		stringBuilder.delete(stringBuilder.lastIndexOf(", "), stringBuilder.length());
		stringBuilder.append(")");
		return stringBuilder.toString();
	}

	public static String buildQueryUpdate(String tableName, String... attributes) {

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < attributes.length - 1; i++) {
			stringBuilder.append(attributes[i] + " = ?, ");
		}

		stringBuilder.delete(stringBuilder.lastIndexOf(", "), stringBuilder.length());

		String sql = "UPDATE " + tableName + " SET " + stringBuilder + " WHERE " + attributes[attributes.length - 1]
				+ " = ?";

		return sql;
	}

	public static String buildQuerySelectCondition(String tableName, List<String> conditions, String... attributes) {

		String sql = "SELECT " + buildAttributes(attributes) + " FROM " + tableName + " WHERE "
				+ buildQueryAnd(conditions);

		return sql;
	}

	public static String buildQueryGetAllOrById(String tableName) {
		String sql = "SELECT * FROM " + tableName;
		return sql;
	}
	
	public static String buildQueryGetAllOrById(String tableName, String idAttribute, Integer id) {
		String sql = "SELECT * FROM " + tableName + " WHERE " + idAttribute + " = " + id;
		return sql;
	}

	public static String buildQueryAnd(List<String> attributes) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < attributes.size(); i++) {
			stringBuilder.append(attributes.get(i) + " = ? AND ");
		}

		stringBuilder.delete(stringBuilder.lastIndexOf(" AND "), stringBuilder.length());
		return stringBuilder.toString();
	}

	public static String buildQueryDelete(String tableName, String... attributes) {
		String sql = "DELETE FROM " + tableName + " WHERE " + buildQueryAnd(Arrays.asList(attributes));
		return sql;
	}
	
}
