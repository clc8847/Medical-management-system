package clc.frame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import clc.main.SQLserver;
import clc.ui.PerTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class SalesMedience extends JPanel {
	private static JTextField textField;
	private static JTable table;
	private static JPanel panel;

	/**
	 * Create the panel.
	 */
	public SalesMedience() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 60, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 801, SpringLayout.WEST, this);
		add(panel);

		JButton button1 = new JButton("\u8D2D\u4E70");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel[] = table.getSelectedRows();
				if(sel.length!=1)
				{
					JOptionPane.showMessageDialog(null, "修改药品操作必须且只能选择一行！");
				}
				else
				{
					SalesNums sn= new SalesNums(table.getValueAt(table.getSelectedRow(), 0).toString());
					sn.setVisible(true);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button1, 17, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, button1, -10, SpringLayout.SOUTH, this);
		button1.setFont(new Font("宋体", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.WEST, button1, 47, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, button1, 145, SpringLayout.WEST, this);
		add(button1);

		JButton button2 = new JButton("\u9000\u51FA");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button2, 0, SpringLayout.NORTH, button1);
		springLayout.putConstraint(SpringLayout.WEST, button2, -150, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, button2, 0, SpringLayout.SOUTH, button1);
		springLayout.putConstraint(SpringLayout.EAST, button2, -52, SpringLayout.EAST, this);
		button2.setFont(new Font("宋体", Font.PLAIN, 18));
		add(button2);

		JLabel tabLabel = new JLabel(
				"\u60A8\u597D\uFF01\u60A8\u53EF\u4EE5\u8F93\u5165\u836F\u54C1\u540D\u79F0\u6216\u836F\u54C1\u7F16\u53F7\u6216\u751F\u4EA7\u5382\u5BB6\u6765\u67E5\u8BE2\u4FE1\u606F");
		springLayout.putConstraint(SpringLayout.NORTH, tabLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tabLabel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabLabel, -12, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, tabLabel, -360, SpringLayout.EAST, this);
		add(tabLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent arg0) {
				refresh();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, textField, 11, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -16, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, textField, 581, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, -8, SpringLayout.EAST, this);
		textField.setColumns(10);
		add(textField);

		JButton searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, tabLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, searchButton, -17, SpringLayout.NORTH, panel);
		panel.setLayout(new BorderLayout(0, 0));
		springLayout.putConstraint(SpringLayout.EAST, searchButton, -4, SpringLayout.WEST, textField);
		searchButton.setIcon(new ImageIcon(SalesMedience.class.getResource("/icons/zoom.png")));
		add(searchButton);
		refresh();
	}

	public static void refresh() {
		panel.removeAll();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://" + "localhost" + ":3306/drugs",
					"root", "root");
			java.sql.Statement sta = connection.createStatement();
			String[] names = null;
			int i, j, RowNum = 0, ColNum = 0;
			Object[][] info = null;
			String sqlstr;
			ResultSet res = null;

			sqlstr = "select count(goods.id) from goods,person where goods.personId=person.id and goods.id like'%"
					+ textField.getText() + "%'";
			res = sta.executeQuery(sqlstr);
			res.next();
			RowNum = res.getInt(1);
			sqlstr = "select goods.id as 药品编号,goodsName as 药品名称,producePlace as 生产厂家,produceDate as 生产日期,period as 保质期,purpose as 用途,price as 价格,num as 库存数量,person.name as 经手人 from goods,person where goods.personId=person.id and goods.id like'%"
					+ textField.getText() + "%' ";

			res = sta.executeQuery(sqlstr);
			java.sql.ResultSetMetaData rsmd = res.getMetaData();
			ColNum = rsmd.getColumnCount();
			names = new String[ColNum];
			for (i = 1; i <= ColNum; i++)
				names[i - 1] = rsmd.getColumnName(i);
			info = new Object[RowNum][];
			i = 0;
			while (res.next()) {
				info[i] = new Object[ColNum];
				for (j = 1; j <= ColNum; j++) {
					info[i][j - 1] = res.getObject(j);
				}
				i++;
			}

			DefaultTableModel model = new DefaultTableModel(info, names);
			panel.setLayout(new BorderLayout(0, 0));
			table = new JTable(model);
			PerTable.makeJTable(table);
			table.setRowSelectionAllowed(false);
			final JScrollPane scrollPane = new JScrollPane(table);
			panel.add(scrollPane);
			panel.updateUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
