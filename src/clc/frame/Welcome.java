package clc.frame;

import javax.swing.JPanel;

import clc.model.Init;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Welcome extends JPanel {

	/**
	 * Create the panel.
	 */
	public Welcome() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel welcomeLabel = new JLabel("\u60A8\u597D\uFF01\u6B22\u8FCE\u767B\u9646\u533B\u836F\u7BA1\u7406\u7CFB\u7EDF");
		welcomeLabel.setIcon(new ImageIcon(Welcome.class.getResource("/icons/main_11.jpg")));
		welcomeLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		welcomeLabel.setBounds(0, 13, 792, 72);
		add(welcomeLabel);
		
		JLabel ZhanghaoLabel = new JLabel();
		ZhanghaoLabel.setText("当前账号："+Init.getZhanghao());
		ZhanghaoLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		ZhanghaoLabel.setBounds(31, 130, 509, 29);
		add(ZhanghaoLabel);
		
		JLabel nameLabel = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		nameLabel.setText("用户姓名："+Init.getUsername());
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		nameLabel.setBounds(31, 172, 509, 29);
		add(nameLabel);
		
		JLabel postLabel = new JLabel("\u7528\u6237\u8EAB\u4EFD\uFF1A");
		postLabel.setText("用户身份："+Init.getStatus());
		postLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		postLabel.setBounds(31, 214, 509, 29);
		add(postLabel);

	}

}
