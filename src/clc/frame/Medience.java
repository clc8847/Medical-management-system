package clc.frame;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import clc.main.SQLserver;
import clc.ui.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JToolBar;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Medience extends JPanel {
	static JTextField textField;
	static JPanel panel;
	static JTable table;
	static JLabel label;

	/**
	 * Create the panel.
	 */
	public Medience() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JToolBar toolBar = new JToolBar();
		springLayout.putConstraint(SpringLayout.NORTH, toolBar, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, toolBar, 413, SpringLayout.WEST, this);
		toolBar.setForeground(Color.WHITE);
		toolBar.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, toolBar, 0, SpringLayout.WEST, this);
		add(toolBar);

		JButton button = new JButton("\u65B0\u589E\u836F\u54C1");
		button.setBackground(Color.WHITE);
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		button.setAlignmentY(Component.TOP_ALIGNMENT);
		button.setIcon(new ImageIcon(Medience.class.getResource("/icons/add_att(1).gif")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedienceInfo m = new MedienceInfo();
				m.setVisible(true);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 20));
		toolBar.add(button);

		JButton button_1 = new JButton("\u4FEE\u6539\u836F\u54C1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel[] = table.getSelectedRows();
				if (sel.length != 1) {
					JOptionPane.showMessageDialog(null, "修改药品操作必须且只能选择一行！");
				} else {
					MedienceUpdate m = new MedienceUpdate(table.getValueAt(table.getSelectedRow(), 0).toString());
					m.setVisible(true);
				}
			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setIcon(new ImageIcon(Medience.class.getResource("/icons/refresh_tab.gif")));
		button_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		button_1.setFont(new Font("楷体", Font.PLAIN, 20));
		button_1.setAlignmentY(0.0f);
		button_1.setText("修改药品");
		toolBar.add(button_1);

		JButton button_2 = new JButton("\u5220\u9664\u836F\u54C1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel[] = table.getSelectedRows();
				for (int i = 0; i < sel.length; i++) {
					String ID = table.getValueAt(sel[i], 0).toString();
					System.out.println(ID);
					SQLserver s = new SQLserver();
					s.getConnection();
					int i1 = s.deleteMedience(ID);
					if (i1 == 0) {
						JOptionPane.showMessageDialog(null, "删除失败！");
					} else {
						refresh();
						JOptionPane.showMessageDialog(null, "药品信息删除成功！");
					}
				}
			}
		});
		button_2.setBackground(Color.WHITE);
		button_2.setIcon(new ImageIcon(Medience.class.getResource("/icons/rem_co(3).gif")));
		button_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		button_2.setFont(new Font("楷体", Font.PLAIN, 20));
		button_2.setAlignmentY(0.0f);
		toolBar.add(button_2);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, toolBar, -6, SpringLayout.NORTH, panel);

		JButton button_3 = new JButton("\u589E\u52A0\u6570\u91CF");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sel[] = table.getSelectedRows();
				if (sel.length != 1) {
					JOptionPane.showMessageDialog(null, "修改药品操作必须且只能选择一行！");
				} else {
					AddNums ad = new AddNums(table.getValueAt(table.getSelectedRow(), 0).toString());
					ad.setVisible(true);
				}
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 20));
		button_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		button_3.setBackground(Color.WHITE);
		button_3.setAlignmentY(0.0f);
		toolBar.add(button_3);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -46, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 37, SpringLayout.NORTH, this);
		panel.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
		add(panel);

		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, panel);
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent arg0) {
				refresh();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, textField, -148, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, -18, SpringLayout.EAST, this);
		add(textField);
		textField.setColumns(10);

		label = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, label, 36, SpringLayout.SOUTH, panel);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(UIManager.getFont("Button.font"));
		springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, panel);
		add(label);

		JButton searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, searchButton, -39, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, searchButton, 31, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, searchButton, -4, SpringLayout.WEST, textField);
		searchButton.setContentAreaFilled(false);
		searchButton.setFocusable(false);
		searchButton.setBackground(Color.WHITE);
		searchButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		searchButton.setIcon(new ImageIcon(Medience.class.getResource("/icons/zoom.png")));
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

			sqlstr = "select count(goods.id) from goods,person where goods.personId=person.id and (goods.id like'%"
					+ textField.getText() + "%'or goodsName like '%" + textField.getText() + "%')";
			res = sta.executeQuery(sqlstr);
			res.next();
			RowNum = res.getInt(1);
			sqlstr = "select goods.id as 药品编号,goodsName as 药品名称,producePlace as 生产厂家,produceDate as 生产日期,period as 保质期,purpose as 用途,price as 价格,num as 库存数量,person.name as 经手人 from goods,person where goods.personId=person.id and (goods.id like'%"
					+ textField.getText() + "%' or goodsName like '%" + textField.getText() + "%')";

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
			label.setText("当前共有" + table.getRowCount() + "条记录");
			table.setRowSelectionAllowed(false);
			final JScrollPane scrollPane_2 = new JScrollPane(table);
			panel.add(scrollPane_2);
			panel.updateUI();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
