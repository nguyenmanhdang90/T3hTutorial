package bai06M2.Vd;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDN;
	private JTextField txtMK;
	private JButton btnEN;
	private JLabel lblTenDN;
	private JLabel lblMK;
	private JButton btnDN;
	private JButton btnVN;

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
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTenDN = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblTenDN.setBounds(61, 56, 92, 14);
		contentPane.add(lblTenDN);
		
		txtTenDN = new JTextField();
		txtTenDN.setBounds(163, 53, 186, 20);
		contentPane.add(txtTenDN);
		txtTenDN.setColumns(10);
		
		lblMK = new JLabel("M\u1EADt kh\u1EA9u");
		lblMK.setBounds(61, 94, 92, 14);
		contentPane.add(lblMK);
		
		txtMK = new JTextField();
		txtMK.setBounds(163, 91, 186, 20);
		contentPane.add(txtMK);
		txtMK.setColumns(10);
		
		btnDN = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDN.setBounds(188, 157, 123, 23);
		contentPane.add(btnDN);
		
		btnVN = new JButton("Vi\u1EC7t");
		btnVN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DoiTieuDe(new Locale("vi", "VN"));
			}
		});
		btnVN.setBounds(188, 11, 102, 23);
		contentPane.add(btnVN);
		
		btnEN = new JButton("Anh");
		btnEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiTieuDe(new Locale("en", "US"));
			}
		});
		btnEN.setBounds(314, 11, 102, 23);
		contentPane.add(btnEN);
	}
	private void DoiTieuDe(Locale lc) {
		ResourceBundle rb = ResourceBundle.getBundle("bai06M2/Vd/dangnhap", lc);
		setTitle(rb.getString("td"));
		lblTenDN.setText(rb.getString("lblTenDN"));
		lblMK.setText(rb.getString("lblMK"));
		btnDN.setText(rb.getString("btnDN"));
		btnVN.setText(rb.getString("btnVN"));
		btnEN.setText(rb.getString("btnEN"));
	}
	
}
