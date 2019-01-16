package bai06M2.baiTap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BaiTap01 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1863608960658200936L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtUser;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaiTap01 frame = new BaiTap01();
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
	public BaiTap01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mau dinh dang user name");
		lblNewLabel.setBounds(36, 38, 160, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(220, 35, 234, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsernameKiemTra = new JLabel("Username kiem tra");
		lblUsernameKiemTra.setBounds(36, 103, 160, 14);
		contentPane.add(lblUsernameKiemTra);
		
		txtUser = new JTextField();
		txtUser.setBounds(220, 100, 234, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnKiemTra = new JButton("Kiem tra");
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText();
				String message = user.matches("[a-z0-9_-]{6,20}") ? "hop le" : "khong hop le";
				txtKetQua.setText(message);
			}
		});
		btnKiemTra.setBounds(178, 160, 91, 23);
		contentPane.add(btnKiemTra);
		
		JLabel lblKetQua = new JLabel("Ket qua");
		lblKetQua.setBounds(36, 217, 160, 14);
		contentPane.add(lblKetQua);
		
		txtKetQua = new JTextField();
		txtKetQua.setEditable(false);
		txtKetQua.setBounds(220, 214, 234, 20);
		contentPane.add(txtKetQua);
		txtKetQua.setColumns(10);
	}
}
