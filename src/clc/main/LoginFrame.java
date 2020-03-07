package clc.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import clc.ui.MyJPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	public static Point origin2 = new Point();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 440);
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
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new MyJPanel();
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

		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u60A8\u7684\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel.setBounds(84, 199, 117, 30);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					passwordField.requestFocus();
				}
			}
		});
		textField.setBounds(211, 199, 234, 30);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\u8F93\u5165\u60A8\u7684\u5BC6\u7801\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(84, 252, 117, 30);
		panel.add(label);

		passwordField = new JPasswordField();
		passwordField.setBounds(211, 252, 234, 30);
		panel.add(passwordField);

		JButton btnNewButton = new JButton("\u5458\u5DE5\u767B\u5F55");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.person();
			}

			/** 员工登录 */
			private void person() {
				SQLserver s = new SQLserver();
				s.getConnection();
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "账号输入不能为空，请输入账号！", "提示消息", JOptionPane.ERROR_MESSAGE);
				} else if (passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "密码输入不能为空，请输入密码！", "提示消息", JOptionPane.ERROR_MESSAGE);
				} else {
					boolean ret = s.personLogin(textField.getText(), passwordField.getText());
					if (ret) {
						dispose();// 关闭当前界面 释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源。
						MainFrame mf = new MainFrame();
						mf.setVisible(true);
					}
					textField.setText("");
					passwordField.setText("");
					textField.requestFocus();
				}
			}
		});
		btnNewButton.setBounds(42, 346, 99, 35);
		panel.add(btnNewButton);

		JButton button = new JButton("\u987E\u5BA2\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.customer();
			}

			/** 客户登录 */
			private void customer() {
				SQLserver s = new SQLserver();
				s.getConnection();
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "账号输入不能为空，请输入账号！", "提示消息", JOptionPane.ERROR_MESSAGE);
				} else if (passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "密码输入不能为空，请输入密码！", "提示消息", JOptionPane.ERROR_MESSAGE);
				} else {
					boolean ret = s.customerLogin(textField.getText(), passwordField.getText());
					if (ret) {
						dispose();// 关闭当前界面 释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源。
						CustomerMainFrame mf = new CustomerMainFrame();
						mf.setVisible(true);
					}
					textField.setText("");
					passwordField.setText("");
					textField.requestFocus();
				}
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 15));
		button.setBounds(155, 346, 99, 35);
		panel.add(button);

		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setFont(new Font("宋体", Font.BOLD, 15));
		button_1.setBounds(405, 346, 99, 35);
		panel.add(button_1);
	}

}
