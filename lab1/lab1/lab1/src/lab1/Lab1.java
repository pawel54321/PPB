package lab1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.xml.sax.SAXException;

public class Lab1 {

    public static void main(String[] args) {
        try {
            
            //<?xml version="1.0"?> <soap:Envelope><soap:Body> <m:GetMean> <m:Array>2,4,0,10</m:Array> </m:GetMean></soap:Body> </soap:Envelope>
            //<?xml version="1.0"?> <soap:Envelope><soap:Body> <m:GetSum> <m:Array>2,4,0,10</m:Array> </m:GetSum></soap:Body> </soap:Envelope>
          
            Scanner s = new Scanner(System.in);
            System.out.println("Żądanie: ");
            String linia = s.nextLine();
            System.out.println();
            System.out.println("Odpowiedź: ");
                        
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            Document dokument = parser.parse(new ByteArrayInputStream(linia.getBytes()));
            Element root = dokument.getDocumentElement();
            
            NodeList list = root.getElementsByTagName("m:Array");
            Node array = list.item(0);
            String str = array.getTextContent();
            String[] tab = str.split(",");
            Node parent = array.getParentNode();
            String p_str = parent.getNodeName();
                        
            int result = 0;
            for(int i=0 ; i<tab.length ; i++) {
                result += Integer.parseInt(tab[i]);
            }
            
            Document dokument2 = parser.newDocument();
            Element root2 = dokument2.createElement("soap:Envelope");
            dokument2.appendChild(root2);
            Element body = dokument2.createElement("soap:Body");
            root2.appendChild(body);
            root2.setAttribute("xmlns:m", "");
            
            if(p_str.equals("m:GetMean")) 
            {
                result /= tab.length;
                
                Element response = dokument2.createElementNS("", "m:getMeanResponse");
                body.appendChild(response);
                Element mean = dokument2.createElementNS("", "m:Mean");
                mean.setTextContent(result+"");
                response.appendChild(mean);
            } 
            else 
            {
                Element response = dokument2.createElementNS("", "m:getSumResponse");
                body.appendChild(response);
                Element sum = dokument2.createElementNS("", "m:Sum");
                sum.setTextContent(result+"");
                response.appendChild(sum);
            }
            
            Transformer przekszt = TransformerFactory.newInstance().newTransformer();
            Source wejscie = new DOMSource(dokument2);
            Result wyjscie = new StreamResult(System.out);
            przekszt.transform(wejscie, wyjscie);
            System.out.println();
            
        } 
        catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            Logger.getLogger(Lab1.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}