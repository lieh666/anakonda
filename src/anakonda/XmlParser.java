package anakonda;

import java.util.ArrayList;
import java.util.List;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class XmlParser extends DefaultHandler {
    List<Widget> wigdets= null;
    GameArea gameArea = null;

    public void startDocument() throws SAXException {
        wigdets = new ArrayList<Widget>();
        gameArea = new GameArea();
    }

    public void endDocument() throws SAXException {

    }

    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {

    }

    public void endElement(String s, String s1, String s2) throws SAXException {

    }

    public void characters(char[] chars, int i, int i1) throws SAXException {

    }
}
