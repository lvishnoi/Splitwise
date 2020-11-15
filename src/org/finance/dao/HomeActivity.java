package org.finance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.finance.model.Group;

public class HomeActivity implements DatabaseCredentials {

	Connection conn = null;
	Statement stmt = null;

	public void addFriend(int userId, int friendId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "insert into friends (user, friend) values (" + userId + ", " + friendId + ")";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addGroup(Group group) {
		int userId = group.getGroupId();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "insert into user_group (name, user) values ('" + group.getGroupName() + "', "
					+ group.getGroupId() + ")";
			stmt.executeUpdate(sql);

			ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id");
			if (rs.next())
				group.setGroupId(Integer.parseInt(rs.getString(1)));
			rs.close();

			sql = "insert into group_friend (group_id, friend) values ('" + group.getGroupId() + "', " + userId + ")";
			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addFrindToGroup(Group group, int usrId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "insert into group_friend (group_id, friend) values ('" + group.getGroupId() + "', " + usrId
					+ ")";
			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Integer> availableFriends(Group grp, int currId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "select DISTINCT f.friend friend from friends f LEFT JOIN group_friend g ON f.friend = g.friend "
					+ "WHERE g.group_id <> " + grp.getGroupId() + " OR g.group_id IS NULL AND f.user = " + currId + " ";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next())
					list.add(rs.getInt("friend"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
