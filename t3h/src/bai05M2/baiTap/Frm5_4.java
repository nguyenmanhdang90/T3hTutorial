package bai05M2.baiTap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frm5_4 extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenSach;
	private JTextField txtTacGia;
	private JTextField txtNXB;
	private JTextField txtGiaBia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm5_4 frame = new Frm5_4();
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
	public Frm5_4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTenSach = new JLabel("Ten sach");
		lblTenSach.setBounds(58, 60, 81, 14);
		contentPane.add(lblTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setBounds(191, 57, 114, 20);
		contentPane.add(txtTenSach);
		txtTenSach.setColumns(10);
		
		JLabel lblTacGia = new JLabel("Tac gia");
		lblTacGia.setBounds(58, 112, 81, 14);
		contentPane.add(lblTacGia);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(191, 109, 114, 20);
		contentPane.add(txtTacGia);
		
		JLabel lblNxb = new JLabel("Nha xuat ban");
		lblNxb.setBounds(58, 160, 81, 14);
		contentPane.add(lblNxb);
		
		txtNXB = new JTextField();
		txtNXB.setColumns(10);
		txtNXB.setBounds(191, 157, 114, 20);
		contentPane.add(txtNXB);
		
		JLabel lblGiaBia = new JLabel("Gia bia");
		lblGiaBia.setBounds(58, 204, 81, 14);
		contentPane.add(lblGiaBia);
		
		txtGiaBia = new JTextField();
		txtGiaBia.setColumns(10);
		txtGiaBia.setBounds(191, 201, 114, 20);
		contentPane.add(txtGiaBia);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThem.setBounds(86, 250, 91, 23);
		contentPane.add(btnThem);
	}

}
