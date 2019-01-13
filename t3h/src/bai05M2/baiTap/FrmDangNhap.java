package bai05M2.baiTap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDangNhap frame = new FrmDangNhap();
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
	public FrmDangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(160, 75, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(58, 78, 92, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(58, 129, 92, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 126, 150, 20);
		contentPane.add(passwordField);
		
		JButton btnDangNhap = new JButton("DangNhap");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				Statement statement = DBConnectionUtils.getConnection("jdbc:mysql://localhost:3306/qlidangnhap?useUnicode=true&characterEncoding=UTF-8");
				try {
					ResultSet rs = statement.executeQuery("select * from user where username='"+username+"'");
					if(rs.next()){
						if(password.equalsIgnoreCase(rs.getString("password"))) {
							JOptionPane.showMessageDialog(rootPane, "Dang nhap sucess");
						} else {
							JOptionPane.showMessageDialog(rootPane, "Dang nhap fail");
						}
						return;
					}
					JOptionPane.showMessageDialog(rootPane, "Dang nhap fail");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDangNhap.setBounds(163, 186, 91, 23);
		contentPane.add(btnDangNhap);
	}
}
