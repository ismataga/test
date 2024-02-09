package com.example.test.cibTv;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;

public class XMLHashedParser extends DefaultHandler implements Serializable {
    private static final long serialVersionUID = -3693049324094339659L;
    public XML_Data data = new XML_Data();
    private XML_Data realdata;
    StringBuffer CurrData;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.CurrData = new StringBuffer();
        XML_Data tmp = new XML_Data();
        tmp.setName(qName);
        tmp.setAttributes(attributes);
        this.realdata.AddChilds(tmp);
        this.realdata = tmp;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.realdata.setValue(this.CurrData.toString().trim());
        this.CurrData = new StringBuffer();
        this.realdata.optimize();
        this.realdata = this.realdata.getParent();
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        this.CurrData.append(ch, start, length);
    }

    private XMLHashedParser() {
        this.data.setName("root");
        this.data.setValue("");
        this.realdata = this.data;
    }

    public static XML_Data parseXmlString(String XmlString) throws ParserConfigurationException, SAXException, IOException {
        InputSource is = new InputSource(new StringReader(XmlString));
        is.setEncoding("UTF-8");
        return parse(is);
    }

    public static XML_Data parse(String XMLfile) throws ParserConfigurationException, SAXException, IOException {
        return parse(new InputSource(new FileInputStream(XMLfile)));
    }

    public static XML_Data parse(InputSource XMLFileSource) throws ParserConfigurationException, SAXException, IOException {
        XMLHashedParser parser = new XMLHashedParser();
        XMLReader myparser = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        myparser.setContentHandler(parser);
        myparser.parse(XMLFileSource);
        parser.data.optimize();
        return parser.data;
    }

    public static String CreateConnection(String XML_File) throws IOException, ParserConfigurationException, SAXException {
        XML_Data data = parse(XML_File).getChildByName("service").getChildByName("database");
        StringBuffer ConnString = new StringBuffer();
        ConnString.append(data.getChildByName("host").getValue()).append("?user=").append(data.getChildByName("user").getValue()).append("&password=").append(data.getChildByName("password").getValue());
        return ConnString.toString();
    }
}
