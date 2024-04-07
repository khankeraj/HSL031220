package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;


public class Authorization {
	
	DBConnection conn=new DBConnection();
	//Connection con=conn.getConnection();
	
	public Map menu(userinfo lb) throws SQLException {

		Map status = new HashMap<String, List>();
		
		Connection con=conn.getConnection();
		
		
		String role_id = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		pst = con
				.prepareStatement("select menu_name, menu_id from menu where menu_id IN"
						+ "(select menu_id from submenu where sub_menu_id IN "
						+ "(select sub_menu_id from accessibility where  access_id = "
						+ "(select access_id from role where  role_id = "
						+ "(select role_id from userinfo where username = '"
						+ lb.getUsername() + "' ))))");

		
		
		rs = pst.executeQuery();
		
		ArrayList<List<String>> selected_menu = new ArrayList<List<String>>();
		
		
		while (rs.next()) {
			List row = new ArrayList<String>();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			selected_menu.add(row);
		}

		pst.close();
		rs.close();
		
		
		
		
		pst = con
				.prepareStatement("select sub_menu_name, menu_id from submenu where sub_menu_id IN"
						+ "(select sub_menu_id from accessibility where  access_id = "
						+ "(select access_id from role where  role_id = "
						+ "(select role_id from userinfo where username = '"
						+ lb.getUsername() + "' )))");
	
		
		//System.out.println("BB::"+pst);
		
		rs = pst.executeQuery();

		ArrayList<List<String>> selected_sub_menu = new ArrayList<List<String>>();

		while (rs.next()) {
			List row = new ArrayList<String>();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			selected_sub_menu.add(row);
		}

		List list = null;
		for (List<String> row : selected_menu) {
			String menu_name = row.get(0);
			String menu_id = row.get(1);

			if (list == null)
				list = new ArrayList<String>();

			for (List<String> row1 : selected_sub_menu) {

				if (menu_id.equals(row1.get(1))) {
					list.add(row1.get(0));

				}
			}

			status.put(menu_name, list);

			list = null;

		}
		
		
		DBConnection.closeConnection();

		return status;

	}
	
	
	
	
	public Map menu1(userinfo lb) throws SQLException {

		Map status = new HashMap<String, List>();
		
		Connection con=conn.getConnection();
		
		
		String role_id = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		
		pst = con
				.prepareStatement("select menu_name, menu_id from menu_admin where menu_id IN"
						+ "(select menu_id from submenu_admin where sub_menu_id IN "
						+ "(select sub_menu_id from accessibility_admin where  access_id = "
						+ "(select access_id from role_admin where  role_id = "
						+ "(select role_id from userinfo_admin where username = '"
						+ lb.getUsername() + "' ))))");

		rs = pst.executeQuery();
		
		ArrayList<List<String>> selected_menu = new ArrayList<List<String>>();
		
		
		while (rs.next()) {
			List row = new ArrayList<String>();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			selected_menu.add(row);
		}

		pst.close();
		rs.close();
		pst = con
				.prepareStatement("select sub_menu_name, menu_id from submenu_admin where sub_menu_id IN"
						+ "(select sub_menu_id from accessibility_admin where access_id = "
						+ "(select access_id from role_admin where  role_id = "
						+ "(select role_id from userinfo_admin where username = '"
						+ lb.getUsername() + "')))");
	
		
		rs = pst.executeQuery();

		ArrayList<List<String>> selected_sub_menu = new ArrayList<List<String>>();

		while (rs.next()) {
			List row = new ArrayList<String>();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			selected_sub_menu.add(row);
		}

		List list = null;
		for (List<String> row : selected_menu) {
			String menu_name = row.get(0);
			String menu_id = row.get(1);

			if (list == null)
				list = new ArrayList<String>();

			for (List<String> row1 : selected_sub_menu) {

				if (menu_id.equals(row1.get(1))) {
					list.add(row1.get(0));

				}
			}

			status.put(menu_name, list);

			list = null;

		}

		DBConnection.closeConnection();
		
		
		return status;

	}

	public Map alertsReportsAndZone(userinfo lb) throws SQLException {

		Map status = new HashMap<String, List>();
		
		Connection con=conn.getConnection();
		
		
		String role_id = null;
		PreparedStatement pst = null;
		ResultSet rs = null;



		try {
			pst = con
					.prepareStatement("select zones, offices, departments, users,city_name from role where role_id= "
							+ "(select role_id from userinfo where username = '"
							+ lb.getUsername() + "')");

			rs = pst.executeQuery();
			ArrayList<String> zodu = new ArrayList<String>();
			if (rs.next()) {
				zodu.add(rs.getString(1));
				zodu.add(rs.getString(2));
				zodu.add(rs.getString(3));
				zodu.add(rs.getString(4));
				zodu.add(rs.getString(5));
			}

			
			
			status.put("zodu", zodu);
			
			String query = "";
			
			try {
				if (zodu.get(0).equals("All-Zones")) {
					query = "";
				} else if (zodu.get(4).equals("All-Citys")) {

					query = "uid IN"
							+ "(select uid from userinfo where zone_name="
							+ "(select zone_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') ))";
				}

				else if (zodu.get(1).equals("All-Offices")) {

					query = "uid IN"
							+ "(select uid from userinfo where city_name="
							+ "(select zone_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') or city_name in ('All-citys')))";
				} else if (zodu.get(2).equals("All-Departments")) {

					query = "uid IN"
							+ "(select uid from userinfo where office_name="
							+ "(select office_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') or city_name in ('All-citys') or offices in ('All-Offices') ))";
				} else if (zodu.get(3).equals("All-Users")) {

					query = "uid IN"
							+ "(select uid from userinfo where dept_name="
							+ "(select dept_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') or city_name in ('All-citys') or offices in ('All-Offices') or departments in ('All-Departments')))";
				} else if (zodu.get(3).equals("Own-User")) {

					query = "uid IN" + "(select uid from userinfo where username='"
							+ lb.getUsername() + "')";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			status.put("query", query);
			pst.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		DBConnection.closeConnection();
		
		return status;

	}
	
	
	public Map alertsReportsAndZone1(userinfo lb) throws SQLException {

		Map status = new HashMap<String, List>();
	
		Connection con=conn.getConnection();
		
		String role_id = null;
		PreparedStatement pst = null;
		ResultSet rs = null;



		try {
			pst = con
					.prepareStatement("select zones, offices, departments, users,city_name from role where role_id= "
							+ "(select role_id from userinfo where username = '"
							+ lb.getUsername() + "')");

			rs = pst.executeQuery();
			ArrayList<String> zodu = new ArrayList<String>();
			if (rs.next()) {
				zodu.add(rs.getString(1));
				zodu.add(rs.getString(2));
				zodu.add(rs.getString(3));
				zodu.add(rs.getString(4));
				zodu.add(rs.getString(5));
			}

			
			
			status.put("zodu", zodu);
			
			String query = "";
			
			try {
				if (zodu.get(0).equals("All-Zones")) {
					query = "";
				} else if (zodu.get(4).equals("All-Citys")) {

					query = "uid IN"
							+ "(select uid from userinfo where zone_name="
							+ "(select zone_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') ))";
				}

				else if (zodu.get(1).equals("All-Offices")) {

					query = "uid IN"
							+ "(select uid from userinfo where city_name="
							+ "(select zone_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') or city_name in ('All-citys')))";
				} else if (zodu.get(2).equals("All-Departments")) {

					query = "uid IN"
							+ "(select uid from userinfo where office_name="
							+ "(select office_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') or city_name in ('All-citys') or offices in ('All-Offices') ))";
				} else if (zodu.get(3).equals("All-Users")) {

					query = "uid IN"
							+ "(select uid from userinfo where dept_name="
							+ "(select dept_name from userinfo where username='"
							+ lb.getUsername()
							+ "') and role_id not in(select role_id from role where zones in('All-Zones') or city_name in ('All-citys') or offices in ('All-Offices') or departments in ('All-Departments')))";
				} else if (zodu.get(3).equals("Own-User")) {

					query = "uid IN" + "(select uid from userinfo where username='"
							+ lb.getUsername() + "')";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			status.put("query", query);
			pst.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection();
		
		return status;

	}

}
