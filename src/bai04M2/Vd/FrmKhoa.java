package bai04M2.Vd;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FrmKhoa extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKhoa frame = new FrmKhoa();
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
	public FrmKhoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 27, 371, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ma Khoa", "Ten Khoa"
			}
		));
		scrollPane.setViewportView(table);

		JButton btnReadXml = new JButton("Read XML");
		btnReadXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				try {
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse(new File("t3h\\src\\bai04M2\\Vd\\khoas.xml"));

					NodeList nodeList = doc.getElementsByTagName("khoa");
					
					List<String> maKhs = IntStream.range(0, nodeList.getLength())
                            .mapToObj(nodeList::item)
                            .map(Node::getChildNodes)
                            .flatMap(node1->{
                            	return IntStream.range(0, node1.getLength())
                            			.mapToObj(node1::item);
                            })
                            .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                            .filter(node -> node.getNodeName().equals("makh"))
                            .map(Node::getTextContent)
                            .collect(Collectors.toList());
					
					List<String> tenKhs = IntStream.range(0, nodeList.getLength())
                            .mapToObj(nodeList::item)
                            .map(Node::getChildNodes)
                            .flatMap(node1->{
                            	return IntStream.range(0, node1.getLength())
                            			.mapToObj(node1::item);
                            })
                            .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                            .filter(node -> !node.getNodeName().equals("makh"))
                            .map(Node::getTextContent)
                            .collect(Collectors.toList());
					
					for (int i =0; i <maKhs.size(); i++){
						dtm.addRow(new String[] { maKhs.get(i), tenKhs.get(i) });
					}
					
					/*for (int i = 0; i < nodeList.getLength(); i++) {
						Node node = nodeList.item(i);
						NodeList nodeList2 = node.getChildNodes();
						String makh = "", tenkh = "";
						for (int j = 0; j < nodeList2.getLength(); j++) {
							Node node2 = nodeList2.item(j);
							if (node2.getNodeType() == Node.ELEMENT_NODE) {
								if (node2.getNodeName().equals("makh"))
									makh = node2.getTextContent();
								else
									tenkh = node2.getTextContent();
							}
						}
						dtm.addRow(new String[] { makh, tenkh });
					}*/
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnReadXml.setBounds(283, 218, 91, 23);
		contentPane.add(btnReadXml);
	}
}
