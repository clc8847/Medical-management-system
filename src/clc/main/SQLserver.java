package clc.main;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clc.model.*;

/**
 * @author clc
 */
public class SQLserver {
	public static Connection con, con1;
	public static Statement stmt;
	public static PreparedStatement ps, ps1;
	public static ResultSet res, res1;

	/* 定义连接数据库方法 */
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/drugs", "root", "root");
			System.out.println("**********连接数据库成功********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// 员工查询账号和密码数据库
	public boolean personLogin(String user, String password) {
		try {
			ps = con.prepareStatement("select * from users,person where user='" + user + "' and password='" + password
					+ "' and users.person_id=person.id");
			res = ps.executeQuery();
			if (res.next()) {
				String use = res.getString("user");
				String pwd = res.getString("password");
				ps1 = con.prepareStatement(
						"select user,name,post,person.id from users,person where users.person_id=person.id");
				res1 = ps1.executeQuery();
				if (res1.next()) {
					Init.zhanghao = res1.getString("user");
					Init.username = res1.getString("name");
					Init.status = res1.getString("post");
					Init.person_id = res1.getString("person.id");
					System.out
							.println(Init.zhanghao + "\t" + Init.username + "\t" + Init.status + "\t" + Init.person_id);
				}
				System.out.println("账号：" + use + ",密码" + pwd);
			} else {
				JOptionPane.showMessageDialog(null, "账号或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// 客户查询账号和密码数据库
	public boolean customerLogin(String user, String password) {
		try {
			ps = con.prepareStatement("select * from users,customer where user='" + user + "' and password='" + password
					+ "' and users.customer_id=customer.id");
			res = ps.executeQuery();
			if (res.next()) {
				String use = res.getString("user");
				String pwd = res.getString("password");
				ps1 = con.prepareStatement(
						"select user,name,customer.id from users,customer where users.customer_id=customer.id");
				res1 = ps1.executeQuery();
				if (res1.next()) {
					Init.zhanghao = res1.getString("user");
					Init.username = res1.getString("name");
					Init.status = "顾客";
					Init.coustomer_id = res1.getString("customer.id");
					System.out.println(
							Init.zhanghao + "\t" + Init.username + "\t" + Init.status + "\t" + Init.coustomer_id);
				}
				System.out.println("账号：" + use + ",密码" + pwd);
			} else {
				JOptionPane.showMessageDialog(null, "账号或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static int addMedience(String id1, String goodsName1, String producePlace1, String produceDate1,
			String period1, String purpose1, String price1, String num1, String personId1) {
		int i = 0;
		try {
			String string = "insert into goods values('" + id1 + "','" + goodsName1 + "','" + producePlace1 + "','"
					+ produceDate1 + "','" + period1 + "','" + purpose1 + "','" + price1 + "','" + num1 + "','"
					+ personId1 + "') ";
			ps = con.prepareStatement(string);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int deleteMedience(String ID) {
		int i = 0;
		try {
			String string = "delete from goods where ID='" + ID + "'";
			ps = con.prepareStatement(string);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int updateMedience(String id1, String goodsName1, String producePlace1, String produceDate1,
			String period1, String purpose1, String price1, String num1, String personId1,String ID) {
		int i = 0;
		try {
			String string = "update goods set id='" + id1 + "',goodsName='" + goodsName1 + "'," + "producePlace='"
					+ producePlace1 + "',produceDate='" + produceDate1 + "'," + "period='" + period1 + "',purpose='"
					+ purpose1 + "',price='" + price1 + "',num='" + num1 + "',personId='"+personId1+"'where ID='"+ID+"'";
			ps = con.prepareStatement(string);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean searchId(String id1) {
		try {
			ps = con.prepareStatement("select * from goods where id='"+id1+"'");
			res = ps.executeQuery();
			if (res.next()) {
				MedienceModel.setId(res.getString("id"));
				MedienceModel.setGoodsName(res.getString("goodsName"));
				MedienceModel.setPeriod(res.getString("period"));
				MedienceModel.setProducePlace(res.getString("producePlace"));
				MedienceModel.setProduceDate(res.getString("produceDate"));
				MedienceModel.setPrice(res.getString("price"));
				MedienceModel.setPurpose(res.getString("purpose"));
				JOptionPane.showMessageDialog(null, "药品编号已存在！");
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public int updateNum(String num1, String id1) {
		int i = 0;
		try {
			String string = "update goods set num=num+'"+num1+"'where id='"+id1+"'";
			ps = con.prepareStatement(string);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}


	public int salesNums(String num1, String ID) {
		int i = 0;
		try {
			String string = "update goods set num=num-'"+num1+"'where id='"+ID+"'";
			ps = con.prepareStatement(string);
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
