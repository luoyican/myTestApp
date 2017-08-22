package com.rfchina.internet.mytestapp.okhttpmodel;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by luoyican on 2017/8/10.
 */

public class XmlContentHandler extends DefaultHandler {
    private String nodeName;
    private StringBuilder id, name, version;
    private String result;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
        result = "";
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        nodeName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("app".equals(localName)) {
            result += "id= " + id.toString().trim() + " name= " + name.toString().trim() + " version= " + version.toString().trim() + "\n";
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if ("id".equals(nodeName)) {
            id.append(ch, start, length);
        } else if ("version".equals(nodeName)) {
            version.append(ch, start, length);
        } else if ("name".equals(nodeName)) {
            name.append(ch, start, length);
        }
    }

    public String getResult() {
        return result;
    }
}
