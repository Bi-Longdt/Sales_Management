package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.ConnectDB;
import controller.LogInController;

public class LogInView extends JFrame {

	private JPanel Left;
	private JPanel Right;
	private JFrame frame;
	private JButton btClear;
	private JButton btLogin;
	private JPasswordField tfPass;
	private JTextField tfUID;

//	public static void main(String[] args) {
//		new LogInView();
//	}

	public LogInView() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException ex) {
				} catch (InstantiationException ex) {
				} catch (IllegalAccessException ex) {
				} catch (UnsupportedLookAndFeelException ex) {
				}

				frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				FormPane(frame);
				frame.pack();
				frame.setSize(600, 400);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}

		});
	}

	public void FormPane(JFrame frame) {
		JPanel formPane = new JPanel();

		formPane.setLayout(null);
		formPane.setBackground(new Color(0, 175, 240));
		formPane.setBounds(0, 0, 600, 400);
		formPane.setLayout(null);

		Left = new JPanel();
		Left.setLayout(null);
		Left.setBounds(0, 0, 200, 361);
		Left.setBackground(new Color(0, 175, 240));
		formPane.add(Left);

		JLabel lbimageLeft = new JLabel();
		lbimageLeft.setBounds(59, 80, 70, 70);
		ImageIcon image = new ImageIcon("image/sale.jpg");
		Image img = image.getImage();
		Image imgSQL = img.getScaledInstance(lbimageLeft.getWidth(), lbimageLeft.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon SQLIcon = new ImageIcon(imgSQL);
		lbimageLeft.setIcon(SQLIcon);
		Left.add(lbimageLeft);

		JLabel lbFamilyPoint = new JLabel("Family Point", SwingConstants.CENTER);
		lbFamilyPoint.setBounds(10, 144, 180, 44);
		lbFamilyPoint.setForeground(Color.WHITE);
		lbFamilyPoint.setBackground(Color.WHITE);
		lbFamilyPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lbFamilyPoint.setFont(new Font("Tahoma", Font.BOLD, 24));
		Left.add(lbFamilyPoint);

		JLabel lbEveryProduct = new JLabel("Every Product", SwingConstants.CENTER);
		lbEveryProduct.setBounds(10, 177, 180, 44);
		lbEveryProduct.setForeground(Color.WHITE);
		lbEveryProduct.setBackground(Color.WHITE);
		lbEveryProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lbEveryProduct.setFont(new Font("Tahoma", Font.BOLD, 24));
		Left.add(lbEveryProduct);

		JLabel lbNiceService = new JLabel("Nice Service", SwingConstants.CENTER);
		lbNiceService.setBounds(10, 210, 180, 44);
		lbNiceService.setForeground(Color.WHITE);
		lbNiceService.setBackground(Color.WHITE);
		lbNiceService.setHorizontalAlignment(SwingConstants.CENTER);
		lbNiceService.setFont(new Font("Tahoma", Font.BOLD, 24));
		Left.add(lbNiceService);

		Right = new JPanel();
		Right.setLayout(null);
		Right.setBounds(201, 0, 383, 361);
		Right.setBackground(Color.WHITE);
		formPane.add(Right);

		JLabel lbLogin = new JLabel("LOGIN");
		lbLogin.setBounds(146, 11, 110, 50);
		lbLogin.setForeground(new Color(0, 175, 240));
		lbLogin.setBackground(Color.WHITE);
		lbLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		Right.add(lbLogin);

		JLabel lbImageRight = new JLabel();
		lbImageRight.setBounds(166, 58, 70, 70);
		ImageIcon image1 = new ImageIcon("image/sale.jpg");
		Image img1 = image1.getImage();
		Image imgSQL1 = img1.getScaledInstance(lbImageRight.getWidth(), lbImageRight.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon SQLIcon1 = new ImageIcon(imgSQL1);
		lbImageRight.setIcon(SQLIcon1);
		Right.add(lbImageRight);

		JLabel lbUID = new JLabel("UID");
		lbUID.setBounds(62, 139, 90, 25);
		lbUID.setForeground(new Color(0, 175, 240));
		lbUID.setBackground(Color.WHITE);
		lbUID.setHorizontalAlignment(SwingConstants.LEFT);
		lbUID.setFont(new Font("Tahoma", Font.BOLD, 15));
		Right.add(lbUID);

		tfUID = new JTextField();
		tfUID.setBounds(166, 143, 150, 20);
		tfUID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUID.setColumns(16);
		Right.add(tfUID);

		JLabel lbPassword = new JLabel("PASSWORD");
		lbPassword.setBounds(62, 175, 90, 25);
		lbPassword.setForeground(new Color(0, 175, 240));
		lbPassword.setBackground(Color.WHITE);
		lbPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		Right.add(lbPassword);

		tfPass = new JPasswordField();
		tfPass.setBounds(166, 179, 150, 20);
		Right.add(tfPass);
		
		ActionListener ac = new LogInController(this);
		btLogin = new JButton("Login");
		btLogin.setForeground(new Color(0, 175, 240));
		btLogin.setBackground(new Color(0, 175, 240));
		btLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btLogin.setBounds(82, 239, 89, 23);
		Right.add(btLogin);
		btLogin.addActionListener(ac);
		
		btClear = new JButton("Clear");
		btClear.setForeground(new Color(0, 175, 240));
		btClear.setBackground(new Color(0, 175, 240));
		btClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btClear.setBounds(207, 239, 89, 23);
		Right.add(btClear);
		btClear.addActionListener(ac);
		
		frame.add(formPane);
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtClear() {
		return btClear;
	}

	public void setBtClear(JButton btClear) {
		this.btClear = btClear;
	}

	public JButton getBtLogin() {
		return btLogin;
	}

	public void setBtLogin(JButton btLogin) {
		this.btLogin = btLogin;
	}

	public JPasswordField getTfPass() {
		return tfPass;
	}

	public void setTfPass(JPasswordField tfPass) {
		this.tfPass = tfPass;
	}

	public JTextField getTfUID() {
		return tfUID;
	}

	public void setTfUID(JTextField tfUID) {
		this.tfUID = tfUID;
	}
	
	

}
