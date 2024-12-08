package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
Created by : Saurav Behera
Last Modified : 14-02-2022 by Saurav Behera
-Updated function definition and formatting
Created Date : 21-01-2022
Synopsis:This class contains database connection and checks if the select quey has some results in the database
 */

public class SQLDatabaseresultset {

	static List<String[]> table;

	public static List<String[]> entryInDatabase(String selectSql) throws IOException, IOException {
		String connectionString = "";
		try (InputStream input = new FileInputStream("src/test/resources/Configuration.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			String username = prop.getProperty("db.username");
			String password = prop.getProperty("db.password");
			String env = "Environment";

			String uatlink = "jdbc:sqlserver://ipru-manthan-uat-db-server.database.windows.net:1433;"
					+ " database=IPRU-MANTHAN-UAT-DB;user= " + username + "@ipru-manthan-uat-db-server;";
			String qalink = "jdbc:sqlserver://ipru-manthan-qa-db-server.database.windows.net:1433;"
					+ "database=IPRU-MANTHAN-QA-DB;user= " + username + "@ipru-manthan-qa-db-server;";
			String devlink = "jdbc:sqlserver://ipru-manthan-dev-db-server.database.windows.net:1433; "
					+ "database=IPRU-MANTHAN-DEV-DB; user= " + username + "@ipru-manthan-dev-db-server;";

			String constring = "password=" + password + ";" + "encrypt=true;" + "trustServerCertificate=false;"
					+ "hostNameInCertificate=*.database.windows.net;" + "loginTimeout=30;";

			if (prop.getProperty(env).equalsIgnoreCase("UAT")) {
				connectionString = uatlink + constring;
			}
			if (prop.getProperty(env).equalsIgnoreCase("QA")) {
				connectionString = qalink + constring;
			}
			if (prop.getProperty(env).equalsIgnoreCase("DEV")) {
				connectionString = devlink + constring;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		if (selectSql.toLowerCase().contains("delete") || selectSql.toLowerCase().contains("update")) {
			table = delete(connectionString, selectSql);
		} else {
			table = select(connectionString, selectSql);
		}

		return table;
	}

	public static List<String[]> select(String connectionString, String selectSql) {
		ResultSet resultSet;
		table = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(connectionString);
				Statement statement = connection.createStatement()) {
			resultSet = statement.executeQuery(selectSql);
			int nCol = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				String[] row = new String[nCol];
				for (int iCol = 1; iCol <= nCol; iCol++) {
					Object obj = resultSet.getObject(iCol);
					if (obj != null) {
						row[iCol - 1] = obj.toString();
					} else {
						row[iCol - 1] = "";
					}
				}
				table.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return table;
	}

	public static List<String[]> delete(String connectionString, String deleteSQL) {
		table = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(connectionString);
				Statement statement = connection.createStatement()) {
			statement.executeUpdate(deleteSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return table;
	}

}
