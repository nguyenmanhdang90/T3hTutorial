package bai05M2.baiTap;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bai05M2.baiTap.DTO.LienHe;
import bai05M2.baiTap.buisinessLogic.LienHeServices;

public class FrmLienHe extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtDTDD;
	private JTextField txtHinhAnh;
	private JButton btnChooseFile;
	private JButton btnThem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLienHe frame = new FrmLienHe();
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
	public FrmLienHe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(117, 51, 119, 20);
		contentPane.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Ho Ten");
		lblHoTen.setBounds(24, 51, 70, 14);
		contentPane.add(lblHoTen);
		
		JLabel lblDtdd = new JLabel("DTDD");
		lblDtdd.setBounds(24, 99, 70, 14);
		contentPane.add(lblDtdd);
		
		txtDTDD = new JTextField();
		txtDTDD.setBounds(117, 99, 119, 20);
		contentPane.add(txtDTDD);
		txtDTDD.setColumns(10);
		
		txtHinhAnh = new JTextField();
		txtHinhAnh.setBounds(117, 154, 119, 20);
		contentPane.add(txtHinhAnh);
		txtHinhAnh.setColumns(10);
		
		JLabel lblHinhAnh = new JLabel("Hinh Anh");
		lblHinhAnh.setBounds(24, 154, 70, 14);
		contentPane.add(lblHinhAnh);
		
		btnChooseFile = new JButton("Chon");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(rootPane);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					txtHinhAnh.setText(fileChooser.getSelectedFile().getAbsolutePath());
				}

			}
		});
		btnChooseFile.setBounds(272, 153, 98, 23);
		contentPane.add(btnChooseFile);
		
		btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LienHe lienHe = new LienHe();
				lienHe.setHoTen(txtHoTen.getText());
				lienHe.setDtdd(txtDTDD.getText());
				lienHe.setHinhAnh(txtHinhAnh.getText());
				int respon = LienHeServices.them(lienHe);
				if(respon == 0) JOptionPane.showMessageDialog(rootPane, "failed");
				else JOptionPane.showMessageDialog(rootPane, "s");
			}
		});
		btnThem.setBounds(158, 185, 91, 23);
		contentPane.add(btnThem);
	}
}
