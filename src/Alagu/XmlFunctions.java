package Alagu;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlFunctions {
	public static void main(String argv[]) {
		XmlFunctions xmlFunctions = new XmlFunctions();

		String filePath = "/Users/irajamo/Documents/workspace/TestProject/Resource/";

		String fileName = "employee.xml";
		String elementName = "Item";
		String attributeName = "entitlementLAC";
	
		boolean checkIfFileExists = xmlFunctions.checkIfFileExist(filePath, fileName); // task 1
		if(checkIfFileExists) {
			String xmlToString = xmlFunctions.convertXMLDocumentToString(filePath, fileName); //task 2
			String entitlementLAC = xmlFunctions.fetchElementByIdFromString(xmlToString, elementName , attributeName);
			System.out.println("entitlementLAC  :"+entitlementLAC);
		}
		//if(checkIfFileExists) xmlFunctions.fetchElementById(filePath, fileName, elementName , attributeName);
	}
	
private String fetchElementByIdFromString(String xmlToString, String elementName, String attributeName) {
		
		String entitlementLAC = "";
		try {
			
			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(new StringReader(xmlToString)));
			doc.getDocumentElement().normalize();
			//System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("payload");
			//System.out.println(nodeList.getLength());
			// nodeList is not iterable, so we are using for loop
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					if ( eElement != null && (eElement.getElementsByTagName(elementName) != null)  && (eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName)!=null)) {
	
					entitlementLAC = eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName).toString();
					
					System.out.println(elementName + " :" + entitlementLAC);
					}
				}
			}
		
		} catch (Exception e) {
			System.out.println(elementName + " or " + attributeName +" doesn't exist" + e.getMessage());
			return entitlementLAC;
		}
		
		if (entitlementLAC.equalsIgnoreCase("")) {
			System.out.println(elementName + " or " + attributeName +" doesn't exist");
		}
		return entitlementLAC;
	}

	private String fetchElementById(String filePath, String fileName, String elementName, String attributeName) {
		
		String entitlementLAC = "";
		try {
			
		
			
			// creating a constructor of file class and parsing an XML file
			File file = new File(filePath + fileName);

			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("payload");
			//System.out.println(nodeList.getLength());
			// nodeList is not iterable, so we are using for loop
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					if ( eElement != null && (eElement.getElementsByTagName(elementName) != null)  && (eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName)!=null)) {
	
					entitlementLAC = eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName).toString();
					
					System.out.println(elementName + " :" + entitlementLAC);
					}
				}
			}
		
		} catch (Exception e) {
			System.out.println(elementName + " or " + attributeName +" doesn't exist");
			return entitlementLAC;
		}
		
		if (entitlementLAC.equalsIgnoreCase("")) {
			System.out.println(elementName + " or " + attributeName +" doesn't exist");
		}
		return entitlementLAC;
	}

	private boolean checkIfFileExist(String filePath, String fileName) {
		try {
			File file = new File(filePath + fileName);
			file.createNewFile();
			return file.exists();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	private  String convertXMLDocumentToString(String filePath, String fileName) {

		// Create a new object of TransformerFactory
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer;

		try {
			// creating a constructor of file class and parsing an XML file
			File file = new File(filePath + fileName);

			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db;

			db = dbf.newDocumentBuilder();

			Document doc = db.parse(file);

			transformer = transformerFactory.newTransformer();

			// Creating object of the Source document that is xml doc
			DOMSource source = new DOMSource(doc);

			StringWriter strWriter = new StringWriter();

			StreamResult stResult = new StreamResult(strWriter);

			transformer.transform(source, stResult);

			String xmlString = strWriter.getBuffer().toString();
		//	System.out.println(xmlString);
			return xmlString;

		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}