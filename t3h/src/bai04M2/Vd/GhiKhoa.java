package bai04M2.Vd;

import java.io.File;

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
import org.w3c.dom.Text;

public class GhiKhoa {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element nodeKhoa = doc.createElement("khoa");
		doc.appendChild(nodeKhoa);

		Element nodeMaKh = doc.createElement("makh");
		nodeKhoa.appendChild(nodeMaKh);

		Element nodeTenKh = doc.createElement("tenkh");
		nodeKhoa.appendChild(nodeTenKh);

		Text maKhText = doc.createTextNode("AV");
		nodeMaKh.appendChild(maKhText);

		Text tenKhText = doc.createTextNode("Anh Van");
		nodeTenKh.appendChild(tenKhText);
		
		//begin write to file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source source = new DOMSource(doc);
		Result result = new StreamResult(new File("t3h\\src\\bai04M2\\Vd\\khoaout.xml"));
		transformer.transform(source, result);
	}

}
