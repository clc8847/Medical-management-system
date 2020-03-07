package clc.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import clc.frame.Medience;
import clc.main.SQLserver;
import clc.model.Init;
import clc.model.MedienceModel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MedienceInfo extends JFrame {

	private JPanel contentPane;
	public static Point origin2 = new Point();
	public static boolean isMax = false;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedienceInfo frame = new MedienceInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MedienceInfo() {
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				origin2.x = e.getX();
				origin2.y = e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point pp = getLocation();
				setLocation(pp.x + e.getX() - origin2.x, pp.y + e.getY() - origin2.y);
			}
		});
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel Label_1 = new JLabel("");
		Label_1.setBounds(1, 1, 406, 78);
		Label_1.setIcon(new ImageIcon(MedienceInfo.class.getResource("/icons/main_01.jpg")));
		panel.add(Label_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(11, 92, 506, 219);
		panel_1.setLayout(null);
		panel_1.setBorder(
				new TitledBorder(null, "\u836F\u54C1\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);

		JLabel label = new JLabel("\u836F\u54C1\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(14, 23, 81, 28);
		panel_1.add(label);

		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(94, 23, 146, 28);
		panel_1.add(textField1);

		JLabel label_1 = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(14, 74, 81, 28);
		panel_1.add(label_1);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(94, 74, 146, 28);
		panel_1.add(textField2);

		JLabel label_2 = new JLabel("\u751F\u4EA7\u5382\u5BB6\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(14, 125, 81, 28);
		panel_1.add(label_2);

		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(94, 125, 146, 28);
		panel_1.add(textField3);

		JLabel label_3 = new JLabel("\u751F\u4EA7\u65E5\u671F\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(14, 176, 81, 28);
		panel_1.add(label_3);

		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(94, 176, 146, 28);
		panel_1.add(textField4);

		JLabel label_4 = new JLabel("\u4FDD\u8D28\u671F\uFF1A");
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(284, 23, 81, 28);
		panel_1.add(label_4);

		textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(345, 23, 146, 28);
		panel_1.add(textField5);

		JLabel label_5 = new JLabel("\u4EF7  \u683C\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(284, 74, 81, 28);
		panel_1.add(label_5);

		textField6 = new JTextField();
		textField6.setColumns(10);
		textField6.setBounds(345, 74, 146, 28);
		panel_1.add(textField6);

		JLabel label_6 = new JLabel("\u6570  \u91CF\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(284, 125, 81, 28);
		panel_1.add(label_6);

		textField7 = new JTextField();
		textField7.setColumns(10);
		textField7.setBounds(345, 125, 146, 28);
		panel_1.add(textField7);

		JLabel label_7 = new JLabel("\u7ECF\u624B\u4EBA\uFF1A");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(284, 176, 81, 28);
		panel_1.add(label_7);

		textField8 = new JTextField();
		textField8.setText(Init.username.toString());
		textField8.setEditable(false);
		textField8.setColumns(10);
		textField8.setBounds(345, 176, 146, 28);
		panel_1.add(textField8);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 312, 430, 41);
		panel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JButton button = new JButton("\u5173\u95ED");
		button.setIcon(new ImageIcon(MedienceInfo.class.getResource("/icons/rem_co(3).gif")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setToolTipText("\u5173\u95ED");
		button.setFont(button.getFont().deriveFont(button.getFont().getSize() + 5f));
		button.setBounds(433, 384, 113, 27);
		panel.add(button);

		JButton button_1 = new JButton("\u4FDD\u5B58");
		button_1.setIcon(new ImageIcon(MedienceInfo.class.getResource("/icons/save_edit(1).gif")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id1 = textField1.getText();
				String goodsName1 = textField2.getText();
				String producePlace1 = textField3.getText();
				String produceDate1 = textField4.getText();
				String period1 = textField5.getText();
				String price1 = textField6.getText();
				String num1 = textField7.getText();
				String purpose1 = textArea.getText();
				String personId1 = Init.getPerson_id().toString();
				if (id1.equals("") || goodsName1.equals("") || producePlace1.equals("") || produceDate1.equals("")
						|| period1.equals("") || price1.equals("") || num1.equals("") || purpose1.equals("")) {
					JOptionPane.showMessageDialog(null, "对不起，您必须输入所有信息，不能为空");
				}else {
					SQLserver s = new SQLserver();
					s.getConnection();
					boolean b = s.searchId(id1);
					if (b == true) {
						JOptionPane.showMessageDialog(null, "药品信息已存在，请选择药品更新按钮！");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
						textField4.setText("");
						textField5.setText("");
						textField6.setText("");
						textField7.setText("");
						textArea.setText("");
						textField8.setText(Init.getUsername().toString());
						dispose();
					}else {
						System.out.println(Init.getPerson_id());
						int i = SQLserver.addMedience(id1, goodsName1, producePlace1, produceDate1, period1, purpose1,
								price1, num1, Init.getPerson_id());
						if (i == 1) {
							JOptionPane.showMessageDialog(null, "药品信息添加成功！");
							dispose();
							Medience.refresh();
						} else {
							JOptionPane.showMessageDialog(null, "药品 信息添加失败");
						}
					}
				}
			}
		});

		button_1.setToolTipText("\u4FDD\u5B58\u836F\u54C1\u4FE1\u606F");
		button_1.setFont(button_1.getFont().deriveFont(button_1.getFont().getSize() + 5f));
		button_1.setBounds(314, 384, 113, 27);
		panel.add(button_1);

		JLabel label_8 = new JLabel("\u7528\u9014\uFF1A");
		label_8.setFont(new Font("仿宋", Font.PLAIN, 18));
		label_8.setBounds(21, 316, 54, 33);
		panel.add(label_8);
	}
}
