package bai04M2.Vd;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class FrmKhoas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaKH;
	private JTextField txtTenKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKhoas frame = new FrmKhoas();
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
	public FrmKhoas() {
		setTitle("Khoas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 31, 347, 117);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 khoa", "T\u00EAn khoa"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btncKhoas = new JButton("\u0110\u1ECDc Khoas");
		btncKhoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);  //xoa cac dong cu neu co
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				try {
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse(new File("t3h\\src\\bai04M2\\Vd\\khoas.xml"));
					NodeList nodeList = doc.getElementsByTagName("khoa");
					for(int i=0; i<nodeList.getLength(); i++) {
						Node node = nodeList.item(i);
						NodeList nodeList2 = node.getChildNodes();
						String makh="", tenkh="";
						for(int j=0; j<nodeList2.getLength(); j++) {
							Node node2 = nodeList2.item(j);
							if(node2.getNodeType()==Node.ELEMENT_NODE) {
								if(node2.getNodeName().equals("makh"))
									makh= node2.getTextContent();
								else
									tenkh = node2.getTextContent();
							}
						}
						dtm.addRow(new String[] {makh,tenkh});
					}
				} catch (ParserConfigurationException | SAXException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btncKhoas.setBounds(276, 159, 119, 23);
		contentPane.add(btncKhoas);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 khoa");
		lblNewLabel.setBounds(82, 241, 79, 14);
		contentPane.add(lblNewLabel);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(171, 238, 86, 20);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn khoa");
		lblNewLabel_1.setBounds(82, 280, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(171, 277, 181, 20);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String makh, tenkh;
				makh = txtMaKH.getText();
				tenkh = txtTenKH.getText();
				
				File file = new File("t3h\\src/bai04M2/Vd/khoas.xml");
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				Document doc;
				try {
					DocumentBuilder db = dbf.newDocumentBuilder();
					if(file.isFile()) 
						doc = db.parse(file);
					else
						doc = db.newDocument();
					Element nutGoc = doc.getDocumentElement();
					if(nutGoc==null) {
						nutGoc = doc.createElement("khoas");
						doc.appendChild(nutGoc);
					}
					
					Element nutKhoa = doc.createElement("khoa");
					nutGoc.appendChild(nutKhoa);
					
					Element nutMaKH = doc.createElement("makh");
					nutKhoa.appendChild(nutMaKH);
					
					Text textMaKH = doc.createTextNode(makh);
					nutMaKH.appendChild(textMaKH);
					
					Element nutTenKH = doc.createElement("tenkh");
					nutKhoa.appendChild(nutTenKH);
					
					Text textTenKH = doc.createTextNode(tenkh);
					nutTenKH.appendChild(textTenKH);
					
					TransformerFactory ttf = TransformerFactory.newInstance();
					Transformer tf = ttf.newTransformer();
					
					Source source = new DOMSource(doc);
					Result result = new StreamResult(file);
					
					tf.transform(source, result);
					
				} catch (ParserConfigurationException | SAXException | IOException | TransformerException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnThem.setBounds(175, 338, 91, 23);
		contentPane.add(btnThem);
	}
}