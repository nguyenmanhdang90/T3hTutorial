package bai04M2.Vd;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Vd1 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("t3h\\src\\bai04M2\\Vd\\khoa.xml"));
		Element nutGoc = doc.getDocumentElement();
		System.out.println(nutGoc.getNodeName());
		System.out.println(nutGoc.getNodeType());
		System.out.println(nutGoc.getChildNodes().getLength());
		System.out.println(nutGoc.getElementsByTagName("makh").item(0).getTextContent());
		NodeList nodeL = nutGoc.getChildNodes();
		for(int i = 0; i <nodeL.getLength(); i++){
			System.out.println(nodeL.item(i).getNodeName());
		}
	}
}
