package clc.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clc.main.SQLserver;
import clc.model.Init;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SalesNums extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField1;

	/**
	 * Create the dialog.
	 * 
	 * @param ID
	 */
	public SalesNums(String ID) {
		setBounds(100, 100, 571, 352);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel label = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(274, 36, 81, 28);
		contentPanel.add(label);

		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setColumns(10);
		textField2.setBounds(354, 36, 146, 28);
		contentPanel.add(textField2);

		JLabel label_1 = new JLabel("\u751F\u4EA7\u5382\u5BB6\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(15, 87, 81, 28);
		contentPanel.add(label_1);

		textField3 = new JTextField();
		textField3.setEditable(false);
		textField3.setColumns(10);
		textField3.setBounds(95, 87, 146, 28);
		contentPanel.add(textField3);

		JLabel label_2 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(274, 87, 81, 28);
		contentPanel.add(label_2);

		textField4 = new JTextField();
		textField4.setEditable(false);
		textField4.setColumns(10);
		textField4.setBounds(354, 87, 146, 28);
		contentPanel.add(textField4);

		JLabel label_3 = new JLabel("\u4FDD \u8D28 \u671F\uFF1A");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(15, 142, 81, 28);
		contentPanel.add(label_3);

		textField5 = new JTextField();
		textField5.setEditable(false);
		textField5.setColumns(10);
		textField5.setBounds(95, 142, 146, 28);
		contentPanel.add(textField5);

		JLabel label_4 = new JLabel("\u4EF7  \u683C\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(274, 142, 81, 28);
		contentPanel.add(label_4);

		textField6 = new JTextField();
		textField6.setEditable(false);
		textField6.setColumns(10);
		textField6.setBounds(354, 142, 146, 28);
		contentPanel.add(textField6);

		JLabel label_5 = new JLabel("\u8D2D\u4E70\u836F\u54C1\u6570\u91CF\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(15, 200, 120, 28);
		contentPanel.add(label_5);

		textField7 = new JTextField();
		textField7.setColumns(10);
		textField7.setBounds(149, 195, 351, 38);
		contentPanel.add(textField7);

		JLabel label_6 = new JLabel("\u836F\u54C1\u7F16\u53F7\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(15, 36, 81, 28);
		contentPanel.add(label_6);


		textField1 = new JTextField();
		textField1.setEditable(false);
		textField1.setColumns(10);
		textField1.setBounds(95, 36, 146, 28);
		contentPanel.add(textField1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A\u8D2D\u4E70");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textField7.equals("")) {
							JOptionPane.showMessageDialog(null, "输入要购买的数量！");
						} else {
							SQLserver s1 = new SQLserver();
							s1.getConnection();
							String num1 = textField7.getText().toString();
							int i1 = s1.salesNums(num1, ID);
							if (i1 == 0) {
								JOptionPane.showMessageDialog(null, "购买失败！");
								
							} else {
								JOptionPane.showMessageDialog(null, "购买成功！");
								SalesMedience.refresh();
								dispose();
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		try {
			SQLserver s = new SQLserver();
			s.getConnection();
			String string = "select * from goods where id='" + ID + "'";
			PreparedStatement ps = SQLserver.con.prepareStatement(string);
			ResultSet res = ps.executeQuery();
			if (res.next()) {

				textField1.setText(res.getString("id"));
				textField2.setText(res.getString("goodsName"));
				textField3.setText(res.getString("producePlace"));
				textField4.setText(res.getString("produceDate"));
				textField5.setText(res.getString("period"));
				textField6.setText(res.getString("price"));
//				textField7.setText(res.getString("num"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
