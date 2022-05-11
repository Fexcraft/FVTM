package net.fexcraft.lib.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;

/**
 * Based off the SQL Util used on the fexcraft.net website.
 * @author Ferdinand (FEX___96)
 */
@Deprecated //TODO update
public class Sql {
	
	private final String user;
	private final String database;
	private final String password;
	private final String port;
	private final String hostname;
	
	private Connection c;
	private Statement s;
	
	public Sql(String... data){
		user = data[0];
		password = data[1];
		port = data[2];
		hostname = data[3];
		database = data[4];
	}
	
	public Connection connect() throws Exception{
		if(isConnected()){
			return c;
		}
		String url = "jdbc:mysql://" + hostname + ":" + port + (database == null ? "" : "/" + database);
		Print.devcon(url);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		c = DriverManager.getConnection(url, user, password);
		return c;
	}
	
	public boolean isConnected() throws SQLException {
		return c != null && !c.isClosed();
	}
	
	public boolean isClosed() throws SQLException {
		return c == null || c.isClosed();
	}

	public Connection getConnection(){
		return c;
	}

	public boolean disconnect() throws Exception {
		if(c == null){
			return false;
		}
		c.close();
		return true;
	}
	
	public Statement getStatement() throws Exception {
		if(!isConnected()){
			connect();
		}
		if(s == null /*|| s.isClosed()*/){
			s = c.createStatement();
		}
		//s = c.createStatement();
		return s;
	}

	public ResultSet query(String query) throws Exception {
		return getStatement().executeQuery(query);
	}

	public int update(String query) throws Exception{
		return getStatement().executeUpdate(query);
	}
	
	public String getString(String target, String table, String compare, String with, String def){
		try{
			ResultSet set = query("SELECT " + target + " FROM " + table + " WHERE " + compare + " = '" + with + "';");
			if(set.first()){
				String s = set.getString(target);
				return target == null ? def : s;
			}
			return def;
		}
		catch(Exception e){
			e.printStackTrace();
			return def;
		}
	}
	
	public String getString(String target, String table, String compare, String with){
		try{
			return getString(target, table, compare, with, null);
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public JsonObject getObject(String target, String table, String compare, String with, String def){
		String s = getString(target, table, compare, with);
		return JsonUtil.getObjectFromString(s == null ? def : s);
	}
	
	public JsonElement getElement(String target, String table, String compare, String with, String def){
		String s = getString(target, table, compare, with);
		return JsonUtil.getFromString(s == null ? def : s);
	}
	
	public JsonObject getObject(String target, String table, String compare, String with){
		return getObject(target, table, compare, with, null);
	}
	
	public int getInt(String target, String table, String compare, String with, int def){
		try{
			ResultSet set = query("SELECT " + target + " FROM " + table + " WHERE " + compare + " = '" + with + "';");
			return set.first() ? set.getInt(target) : def;
		}
		catch(Exception ex){
			//ex.printStackTrace();
			return def;
		}
	}
	
	public int getInt(String target, String table, String compare, String with){
		return getInt(target, table, compare, with, -1);
	}
	
	public boolean exists(String target, String table, String compare, String with, boolean def){
		try{
			return query("SELECT " + target + " FROM " + table + " WHERE " + compare + " = '" + with + "' LIMIT 1;").first();
		}
		catch(Exception ex){
			ex.printStackTrace();
			return def;
		}
	}
	
	public boolean exists(String target, String table, String equals, boolean def){
		try{
			return query("SELECT " + target + " FROM " + table + " WHERE " + equals + " LIMIT 1;").first();
		}
		catch(Exception ex){
			ex.printStackTrace();
			return def;
		}
	}
	
	public int update(String table, String set, String compare, String with) throws Exception {
		return update("UPDATE " + table + " SET " + set + " WHERE " + compare + " = '" + with + "';");
	}
	
	public int update(String table, String set, String compare, int with) throws Exception {
		return update("UPDATE " + table + " SET " + set + " WHERE " + compare + " = '" + with + "';");
	}

	public int update(String table, String set, Object to, String where, Object equals) throws Exception {
		return update("UPDATE " + table + " SET " + set + "='" + to.toString() + "' WHERE " + where + "='" + equals.toString() + "';");
	}

	public int insert(String table, String rows, String content) throws Exception {
		return update("INSERT INTO "+ table +" (" + rows + ") VALUES (" + content + ");");
	}

	public ArrayList<Integer> getArray(String select, String from, String where, int equals, String orderby, boolean desc){
		ArrayList<Integer> array = new ArrayList<Integer>();
		try{
			ResultSet set = query("SELECT " + select + " FROM " + from + " WHERE " + where + " = '" + equals + "' ORDER BY " + orderby + (desc ? " DESC;" : " ASC;"));
			while(set.next()){
				array.add(set.getInt(select));
			}
			return array;
		}
		catch(Exception e){
			return array;
		}
	}

	public ArrayList<Integer> getArray(String select, String from, String where, int equals, String orderby, boolean desc, int limit){
		ArrayList<Integer> array = new ArrayList<Integer>();
		try{
			int i = 0;
			ResultSet set = query("SELECT " + select + " FROM " + from + " WHERE " + where + " = '" + equals + "' ORDER BY " + orderby + (desc ? " DESC;" : " ASC;"));
			while(set.next() && i < limit){
				array.add(set.getInt(select));
				i++;
			}
			return array;
		}
		catch(Exception e){
			return array;
		}
	}

	public String getDataBaseId(){
		return this.database;
	}

	public ArrayList<Integer> getArray(String select, String from, String orderby, boolean desc, int limit){
		ArrayList<Integer> array = new ArrayList<Integer>();
		try{
			limit = limit < 0 ? Integer.MAX_VALUE : 0;
			int i = 0;
			ResultSet set = query("SELECT " + select + " FROM " + from + " ORDER BY " + orderby + (desc ? " DESC;" : " ASC;"));
			while(set.next() && i < limit){
				array.add(set.getInt(select));
				i++;
			}
			return array;
		}
		catch(Exception e){
			return array;
		}
	}
	
}