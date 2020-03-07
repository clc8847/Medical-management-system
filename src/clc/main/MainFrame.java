package clc.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import clc.frame.Medience;
import clc.frame.Welcome;
import clc.ui.NaviBarPanel;
import clc.ui.NaviBarPanel2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static Point origin2 = new Point();
	public static boolean isMax = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
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
		setBounds(100, 100, 829, 510);
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
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel Label_1 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, Label_1, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, Label_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Label_1, 78, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, Label_1, 385, SpringLayout.WEST, panel);
		Label_1.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/main_01.jpg")));
		panel.add(Label_1);

		JPanel panel_1 = new NaviBarPanel();
		panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.SOUTH, Label_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 59, SpringLayout.SOUTH, Label_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		panel.add(panel_1);

		JPanel panel_2 = new NaviBarPanel2();
		panel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, -491, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		panel_1.setLayout(null);

		JPanel mainPanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, mainPanel, 0, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, mainPanel, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, mainPanel, 0, SpringLayout.EAST, panel);
		mainPanel.setBackground(Color.WHITE);
		panel.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));

		JButton button1 = new JButton("\u9996\u9875");
		button1.setForeground(Color.WHITE);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll();
				Welcome wp = new Welcome();
				mainPanel.add(wp);
				mainPanel.updateUI();
			}
		});
		button1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(final MouseEvent arg0) {
				button1.setForeground(Color.YELLOW);
			}

			public void mouseExited(final MouseEvent arg0) {
				button1.setForeground(new Color(255, 255, 255));
			}
		});
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.setBorder(new EmptyBorder(0, 0, 0, 0));
		button1.setContentAreaFilled(false);
		button1.setFont(new Font("楷体", Font.BOLD, 20));
		button1.setBounds(28, 19, 101, 40);
		panel_1.add(button1);

		JButton button2 = new JButton("\u836F\u54C1\u4FE1\u606F");
		button2.setForeground(Color.WHITE);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.removeAll();
				Medience mf = new Medience();
				mainPanel.add(mf);
				mainPanel.updateUI();
			}
		});
		button2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(final MouseEvent arg0) {
				button2.setForeground(Color.YELLOW);
			}

			public void mouseExited(final MouseEvent arg0) {
				button2.setForeground(new Color(255, 255, 255));
			}
		});
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setFont(new Font("楷体", Font.BOLD, 20));
		button2.setContentAreaFilled(false);
		button2.setBorder(new EmptyBorder(0, 0, 0, 0));
		button2.setBounds(143, 19, 101, 40);
		panel_1.add(button2);

		JButton button4 = new JButton("\u7CFB\u7EDF\u6CE8\u9500");
		button4.setForeground(Color.WHITE);
		button4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(final MouseEvent arg0) {
				button4.setForeground(Color.YELLOW);
			}

			public void mouseExited(final MouseEvent arg0) {
				button4.setForeground(new Color(255, 255, 255));
			}
		});
		button4.setBorderPainted(false);
		button4.setFocusPainted(false);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame l = new LoginFrame();
				l.setVisible(true);
			}
		});
		button4.setFont(new Font("楷体", Font.BOLD, 20));
		button4.setContentAreaFilled(false);
		button4.setBorder(new EmptyBorder(0, 0, 0, 0));
		button4.setBounds(412, 19, 101, 40);
		panel_1.add(button4);
		
		JButton button = new JButton("\u5B8C\u5584\u4FE1\u606F");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("楷体", Font.BOLD, 20));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setBounds(283, 19, 101, 40);
		panel_1.add(button);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton minButton = new JButton("");
		minButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		minButton.setContentAreaFilled(false);
		minButton.setRequestFocusEnabled(false);
		minButton.setOpaque(false);
		minButton.setBounds(364, 0, 35, 18);
		panel_2.add(minButton);
		minButton.setFocusPainted(false);
		minButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		minButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/icons/min11.png")));
		minButton.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/min1.png")));

		JButton maxButton = new JButton("");
		maxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isMax == false) {
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					isMax = true;
				} else {
					setExtendedState(JFrame.NORMAL);
					isMax = false;
				}
			}
		});
		maxButton.setContentAreaFilled(false);
		maxButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/icons/max11.png")));
		maxButton.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/max1.png")));
		maxButton.setFocusPainted(false);
		maxButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		maxButton.setBounds(402, 0, 35, 18);
		panel_2.add(maxButton);

		JButton closeButton = new JButton("");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setContentAreaFilled(false);
		closeButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/icons/close11.png")));
		closeButton.setIcon(new ImageIcon(MainFrame.class.getResource("/icons/close1.png")));
		closeButton.setFocusPainted(false);
		closeButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		closeButton.setBounds(442, 0, 35, 18);
		panel_2.add(closeButton);

		Welcome wp = new Welcome();
		mainPanel.add(wp);

	}
}
